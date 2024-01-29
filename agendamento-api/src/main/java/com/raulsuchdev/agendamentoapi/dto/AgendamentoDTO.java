package com.raulsuchdev.agendamentoapi.dto;

import com.raulsuchdev.agendamentoapi.model.Agendamento;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

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
    private Float porcentagemTaxa;
    private BigDecimal valorBaseTaxa;
    private LocalDate dataTransferencia;
    private LocalDate dataAgendamento;

    public static AgendamentoDTO fromEntity(Agendamento agendamento) {
        return AgendamentoDTO.builder()
                .id(agendamento.getId())
                .dataAgendamento(agendamento.getDataAgendamento())
                .dataTransferencia(agendamento.getDataTransferencia())
                .contaDestino(agendamento.getContaDestino())
                .contaOrigem(agendamento.getContaOrigem())
                .porcentagemTaxa(agendamento.getTaxaTransferencia().getPorcentagemTaxa())
                .valorBaseTaxa(agendamento.getTaxaTransferencia().getValorBase())
                .valorTransferencia(agendamento.getValorTransferencia())
                .build();
    }
}
