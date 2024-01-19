package com.raulsuchdev.agendamentoapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "AGENDAMENTO")
public class Agendamento {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "CONTA_ORIGEM")
    private String contaOrigem;

    @Column(name = "CONTA_DESTINO")
    private String contaDestino;

    @Column(name = "VALOR_TRANSFERENCIA")
    private BigDecimal valorTransferencia;

    @Column(name = "TAXA_TRANSFERENCIA")
    private Float taxaTransferencia;

    @Column(name = "DATA_TRANSFERENCIA")
    private Date dataTransferencia;

    @Column(name = "DATA_AGENDAMENTO")
    private Date dataAgendamento;

    @ManyToOne
    @JoinColumn(name = "STATUS_ID")
    private AgendamentoStatus agendamentoStatus;
}
