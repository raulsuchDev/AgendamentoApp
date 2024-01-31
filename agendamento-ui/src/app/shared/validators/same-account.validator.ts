import { AbstractControl, ValidatorFn, ValidationErrors } from "@angular/forms";

export const sameAccountIdValidator: ValidatorFn = (control: AbstractControl): ValidationErrors | null => {
    const contaOrigem = control.get('contaOrigem')?.value;
    const contaDestino = control.get('contaDestino')?.value;

    return contaOrigem && 
        contaDestino && 
        contaDestino === contaOrigem ? { sameAccountId: true } : null;
}