import { AbstractControl, ValidationErrors, ValidatorFn } from "@angular/forms";
import { DateTime } from "luxon";

export const dateBeforeTodayValidator: ValidatorFn = (control: AbstractControl): ValidationErrors | null => {
    const dataTransferencia = control.get('dataTransferencia')?.value;
    return dataTransferencia && 
        !DateTime.fromISO(dataTransferencia).diffNow('days').isValid ?
            {dateBeforeToday: true} : null;
}