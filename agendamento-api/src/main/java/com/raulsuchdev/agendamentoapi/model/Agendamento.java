package com.raulsuchdev.agendamentoapi.model;

import com.raulsuchdev.agendamentoapi.dto.AgendamentoDTO;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "AGENDAMENTO")
@Builder
public class Agendamento {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "CONTA_ORIGEM")
    private String contaOrigem;

    @Column(name = "CONTA_DESTINO")
    private String contaDestino;

    @Column(name = "VALOR_TRANSFERENCIA")
    private BigDecimal valorTransferencia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TAXA_TRANSFERENCIA_ID")
    private TaxaTransferencia taxaTransferencia;

    @Column(name = "DATA_TRANSFERENCIA", columnDefinition = "TIMESTAMP")
    private LocalDateTime dataTransferencia;

    @Column(name = "DATA_AGENDAMENTO", columnDefinition = "TIMESTAMP")
    private LocalDateTime dataAgendamento;

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STATUS_ID")
    private AgendamentoStatus agendamentoStatus;*/

    public static Agendamento criarNovo(AgendamentoDTO novoAgendamento, TaxaTransferencia taxaTransferencia) {
        return Agendamento.builder()
                .contaOrigem(novoAgendamento.getContaOrigem())
                .contaDestino(novoAgendamento.getContaDestino())
                .dataAgendamento(novoAgendamento.getDataAgendamento())
                .dataTransferencia(novoAgendamento.getDataTransferencia())
                .taxaTransferencia(taxaTransferencia)
                .valorTransferencia(novoAgendamento.getValorTransferencia())
                .build();
    }
}
