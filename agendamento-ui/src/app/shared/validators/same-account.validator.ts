import { AbstractControl, ValidatorFn, ValidationErrors } from "@angular/forms";

export const sameAccountIdValidator: ValidatorFn = (control: AbstractControl): ValidationErrors | null => {
    const contaOrigem = control.get('contaOrigem');
    const contaDestino = control.get('contaDestino');

    return contaOrigem && 
        contaDestino && 
        contaDestino === contaOrigem ? { sameAccountId: true } : null;
}