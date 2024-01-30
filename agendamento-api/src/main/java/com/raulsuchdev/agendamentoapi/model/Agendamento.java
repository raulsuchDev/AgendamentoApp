package com.raulsuchdev.agendamentoapi.model;

import com.raulsuchdev.agendamentoapi.dto.NovoAgendamento;
import com.raulsuchdev.agendamentoapi.utils.DateUtil;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "AGENDAMENTO")
@Builder
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private LocalDate dataTransferencia;

    @Column(name = "DATA_AGENDAMENTO", columnDefinition = "TIMESTAMP")
    private LocalDate dataAgendamento;

    public static Agendamento criarNovo(NovoAgendamento novoAgendamento, LocalDate dtAgendamento, TaxaTransferencia taxaTransferencia) {
        return Agendamento.builder()
                .contaOrigem(novoAgendamento.getContaOrigem())
                .contaDestino(novoAgendamento.getContaDestino())
                .dataAgendamento(dtAgendamento)
                .dataTransferencia(novoAgendamento.getDataTransferencia())
                .taxaTransferencia(taxaTransferencia)
                .valorTransferencia(novoAgendamento.getValorTransferencia())
                .build();
    }
}
