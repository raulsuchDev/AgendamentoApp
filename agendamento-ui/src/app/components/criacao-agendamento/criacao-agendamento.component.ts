import { Component, inject } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { AbstractControl, FormBuilder, FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { sameAccountIdValidator } from '../../shared/validators/same-account.validator';
import { DateTime } from 'luxon';
import { dateBeforeTodayValidator } from '../../shared/validators/date-before-today.validator';
import { MatDatepickerModule } from '@angular/material/datepicker'; 
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { MatSnackBar, MatSnackBarModule } from '@angular/material/snack-bar';
import { NovoAgendamento } from '../../core/types/novo-agendamento.type';
import { AgendamentoService } from '../../core/services/agendamento.service';

@Component({
  selector: 'app-criacao-agendamento',
  standalone: true,
  imports: [
    CommonModule,
    MatCardModule, 
    MatButtonModule, 
    MatFormFieldModule, 
    ReactiveFormsModule,
    MatInputModule,
    MatDatepickerModule,
    MatSnackBarModule
  ],
  templateUrl: './criacao-agendamento.component.html',
  styleUrl: './criacao-agendamento.component.scss'
})
export class CriacaoAgendamentoComponent {
  private router: Router = inject(Router);
  private agendamentoService: AgendamentoService = inject(AgendamentoService);
  public today: string;

  formGroup: FormGroup = this._fb.group({
    contaOrigem: new FormControl<string>('', {
      validators: [
        Validators.required,
        Validators.pattern(/\D/g),
        Validators.minLength(10),
        Validators.maxLength(10)
      ]
    }),
    contaDestino: new FormControl<string>('', {
      validators: [
        Validators.required,
        Validators.pattern(/[^\D]*/g),
        Validators.minLength(10),
        Validators.maxLength(10)
      ]      
    }),
    valorTransferencia: new FormControl<number>(Number(0.01), {
      validators: [
        Validators.required,
        Validators.min(0.01)
      ]
    }),
    dataTransferencia: new FormControl<Date>(new Date(), {
      validators: [
        Validators.required,
        dateBeforeTodayValidator
      ]
    })
  }, {
    validators: sameAccountIdValidator
  });
  
  constructor(private _fb: FormBuilder, private _snackbar: MatSnackBar) {
    this.today = DateTime.now().toISO();
  }

  control(controlName: string): AbstractControl | null {
    return this.formGroup.controls[controlName];
  }

  criarNovoAgendamento(event: Event): void {
    event.preventDefault();
    this.formGroup.updateValueAndValidity();
    if (this.formGroup.invalid) {
      this._snackbar.open('Dados inválidos, tente novamente!', 'OK');
    }

    console.log('formGroup value:', this.formGroup.value);

    const novoAgendamento: NovoAgendamento = this.formGroup.value;

    const oldDate = novoAgendamento.dataTransferencia;
    const newDate = <string>DateTime.fromISO(oldDate).toISODate();
    novoAgendamento.dataTransferencia = newDate;

    console.log('novoAgendamento value', novoAgendamento);

    this.agendamentoService.criarAgendamento(novoAgendamento)
      .subscribe({
        next: res => {
          this.formGroup.reset();
          this._snackbar.open(res.message, 'OK');          
        },
        error: err => this._snackbar.open('Erro na criação do agendamento', 'OK')
      });
  }

  cancelar(): void {
    this.router.navigateByUrl('/pagina-principal');
  }

  get minimumTransferValue(): number {
    return Number(0.01);
  }

}
