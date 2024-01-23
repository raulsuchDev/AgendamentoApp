package com.raulsuchdev.agendamentoapi.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TAXA_TRANSFERENCIA")
public class TaxaTransferencia {

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "INTERVALO_DIAS_INICIO")
    private Long intervaloDiasInicio;

    @Column(name = "INTERVALO_DIAS_FINAL")
    private Long intervaloDiasFinal;

    @Column(name = "VALOR_BASE")
    private BigDecimal valorBase;

    @Column(name = "PORCENTAGEM_TAXA")
    private Float porcentagemTaxa;

}
