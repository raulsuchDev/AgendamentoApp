import { DateTime } from "luxon";

export class Agendamento {
    id?: number;
    contaOrigem?: string;
    contaDestino?: string;
    valorTransferencia?: number;
    porcentagemTaxa?: number;
    valorBaseTaxa?: number;
    dataTransferencia?: string;
    dataAgendamento?: Date;
}