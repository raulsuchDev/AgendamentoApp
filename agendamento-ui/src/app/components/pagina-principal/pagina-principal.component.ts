import { Component, OnInit, inject } from '@angular/core';
import { AgendamentoService } from '../../core/services/agendamento.service';
import { Agendamento } from '../../core/dto/agendamento';
import { CommonModule } from '@angular/common';
import { map } from 'rxjs';
import { RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-pagina-principal',
  standalone: true,
  imports: [CommonModule, RouterOutlet, RouterLink, RouterLinkActive],
  templateUrl: './pagina-principal.component.html',
  styleUrl: './pagina-principal.component.scss'
})
export class PaginaPrincipalComponent implements OnInit {
  private agendamentoService: AgendamentoService = inject(AgendamentoService);

  agendamentos: Agendamento[] = [];

  ngOnInit(): void {
    this.agendamentoService.listarAgendamentos()
      .pipe(map(agendamentos => <any>agendamentos))
      .subscribe( 
        (agendamentos) => this.agendamentos = agendamentos
      );
  }
}
