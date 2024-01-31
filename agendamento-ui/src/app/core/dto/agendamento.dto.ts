
export class Agendamento {
    id?: number;
    contaOrigem?: string;
    contaDestino?: string;
    valorTransferencia?: number;
    porcentagemTaxa?: number | string | null | undefined;
    valorBaseTaxa?: number;
    dataTransferencia?: string | null;
    dataAgendamento?: string;
}