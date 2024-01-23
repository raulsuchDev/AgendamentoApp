package com.raulsuchdev.agendamentoapi.enums;

public enum AgendamentoStatusEnum {
    AGENDADO(1),
    CANCELADO(2),
    CONCLUIDO(3),
    FALHA_TRANSFERENCIA(4);

    private Integer agendamentoStatusId;

    AgendamentoStatusEnum(Integer agendamentoStatusId) {
        this.agendamentoStatusId = agendamentoStatusId;
    }

}
