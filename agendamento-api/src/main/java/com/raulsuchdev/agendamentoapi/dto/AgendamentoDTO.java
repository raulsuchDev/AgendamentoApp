package com.raulsuchdev.agendamentoapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.raulsuchdev.agendamentoapi.model.Agendamento;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AgendamentoDTO {
    private Long id;
    private String contaOrigem;
    private String contaDestino;
    private BigDecimal valorTransferencia;
    private Float taxaTransferencia;
    private Date dataTransferencia;
    private Date dataAgendamento;
    private String agendamentoStatus;

    public static AgendamentoDTO fromEntity(Agendamento agendamento) {
        return AgendamentoDTO.builder()
                .id(agendamento.getId())
                .agendamentoStatus(agendamento.getAgendamentoStatus().getDescricao())
                .dataAgendamento(agendamento.getDataAgendamento())
                .dataTransferencia(agendamento.getDataTransferencia())
                .contaDestino(agendamento.getContaDestino())
                .contaOrigem(agendamento.getContaOrigem())
                .taxaTransferencia(agendamento.getTaxaTransferencia())
                .valorTransferencia(agendamento.getValorTransferencia())
                .build();
    }
}
