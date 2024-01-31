import { Component, inject } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { AbstractControl, FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { MAT_FORM_FIELD_DEFAULT_OPTIONS, MatFormFieldModule } from '@angular/material/form-field';
import { sameAccountIdValidator } from '../../shared/validators/same-account.validator';
import { DateTime } from 'luxon';
import { dateBeforeTodayValidator } from '../../shared/validators/date-before-today.validator';
import { MatDatepickerModule } from '@angular/material/datepicker'; 
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { MatSnackBar, MatSnackBarModule } from '@angular/material/snack-bar';
import { NovoAgendamento } from '../../core/types/novo-agendamento.type';
import { AgendamentoService } from '../../core/services/agendamento.service';
import { MatDividerModule } from '@angular/material/divider';
import { NgxCurrencyDirective } from "ngx-currency";

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
    MatSnackBarModule,
    MatDividerModule,
    NgxCurrencyDirective
  ],
  providers: [
    {provide: MAT_FORM_FIELD_DEFAULT_OPTIONS, useValue: {floatLabel: 'always', appearance: 'outline'}},
  ],
  templateUrl: './criacao-agendamento.component.html',
  styleUrl: './criacao-agendamento.component.scss'
})
export class CriacaoAgendamentoComponent {
  private router: Router = inject(Router);
  private agendamentoService: AgendamentoService = inject(AgendamentoService);
  public today: DateTime;
  submittingForm = false;

  formGroup: FormGroup = this._fb.group({
    contaOrigem: new FormControl<string>('', {
      validators: [
        Validators.required,
        Validators.pattern(/^\d+$/),
        Validators.minLength(10),
        Validators.maxLength(10)
      ]
    }),
    contaDestino: new FormControl<string>('', {
      validators: [
        Validators.required,
        Validators.pattern(/^\d+$/),
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
    dataTransferencia: new FormControl<string>(DateTime.local().toISODate(), {
      validators: [
        Validators.required,
        dateBeforeTodayValidator
      ]
    })
  }, {
    validators: [sameAccountIdValidator]
  });
  
  constructor(private _fb: FormBuilder, private _snackbar: MatSnackBar) {
    this.today = DateTime.now();
  }

  filtroData = (d: DateTime | null): boolean => {
    const date = (d || DateTime.now());
    return date.toLocal().plus({ day: 1 }) >= DateTime.now();
  };

  control(controlName: string): AbstractControl | null {
    return this.formGroup.controls[controlName];
  }

  criarNovoAgendamento(event: Event): void {
    event.preventDefault();
    this.formGroup.updateValueAndValidity();
    if (this.formGroup.invalid) {
      this._snackbar.open('Dados inválidos, tente novamente!', 'OK');
      return;
    }

    const {dataTransferencia} = this.formGroup.value;

    const novoAgendamento: NovoAgendamento = this.formGroup.value;
    novoAgendamento.dataTransferencia = DateTime.fromISO(dataTransferencia).toISODate();

    this.submittingForm = false;
    this.agendamentoService.criarAgendamento(novoAgendamento)
      .subscribe({
        next: res => {
          this.formGroup.reset();
          this._snackbar.open(res.message, 'OK');
          this.router.navigateByUrl('/pagina-principal');
        },
        error: err => this._snackbar.open('Ocorreu um erro na criação de agendamento', 'OK'),
        complete: () => this.submittingForm = true
      });
  }

  cancelar(): void {
    this.router.navigateByUrl('/pagina-principal');
  }

  get minimumTransferValue(): number {
    return Number(0.01);
  }

}
