import { Agendamento } from "../dto/agendamento.dto";

export type NovoAgendamento = 
    Required<Pick<Agendamento, 'contaOrigem' | 'contaDestino' | 'dataTransferencia' | 'valorTransferencia'>>;