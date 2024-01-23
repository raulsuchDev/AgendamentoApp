package com.raulsuchdev.agendamentoapi.dto;

import com.raulsuchdev.agendamentoapi.model.Agendamento;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
    private LocalDateTime dataTransferencia;
    private LocalDateTime dataAgendamento;
    //private String agendamentoStatus;

    public static AgendamentoDTO fromEntity(Agendamento agendamento) {
        return AgendamentoDTO.builder()
                .id(agendamento.getId())
                //.agendamentoStatus(agendamento.getAgendamentoStatus().getDescricao())
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
