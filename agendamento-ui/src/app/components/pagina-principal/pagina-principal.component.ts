import { Component, LOCALE_ID, OnInit, inject } from '@angular/core';
import { AgendamentoService } from '../../core/services/agendamento.service';
import { Agendamento } from '../../core/dto/agendamento.dto';
import { CommonModule } from '@angular/common';
import { RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';
import { MatButtonModule } from '@angular/material/button';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatCardModule } from "@angular/material/card";
import { MatListModule } from "@angular/material/list";
import { MatDividerModule } from '@angular/material/divider';
import { map } from 'rxjs';

@Component({
  selector: 'app-pagina-principal',
  standalone: true,
  imports: [
    CommonModule, 
    RouterOutlet, 
    RouterLink, 
    RouterLinkActive, 
    MatButtonModule,
    MatToolbarModule,
    MatCardModule,
    MatListModule,
    MatDividerModule
  ],
  templateUrl: './pagina-principal.component.html',
  styleUrl: './pagina-principal.component.scss'
})
export class PaginaPrincipalComponent implements OnInit {
  private agendamentoService: AgendamentoService = inject(AgendamentoService);

  agendamentos: Agendamento[] = [];

  ngOnInit(): void {
    this.agendamentoService.listarAgendamentos()
      .pipe(
        map(agendamentos => {
          return agendamentos.map(
            agendamento => {
              agendamento.porcentagemTaxa = String(agendamento.porcentagemTaxa);
              return agendamento;
            }
          );
        })
      )
      .subscribe( 
        (agendamentos) => this.agendamentos = agendamentos
      );
  }

  getValorTotal(agd: Agendamento): number {
    const vtr: number = agd?.valorTransferencia ?? 0;
    const pt: number = agd?.porcentagemTaxa && 
      !Number.isNaN(agd.porcentagemTaxa) && 
      Number(agd.porcentagemTaxa) > 0 ?
      Number(agd.porcentagemTaxa) / 100 : 0;
    const vbt: number = agd?.valorBaseTaxa ?? 0;
    return vtr + (vtr * pt) + vbt;
  }
}
