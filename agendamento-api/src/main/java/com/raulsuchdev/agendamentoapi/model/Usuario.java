package com.raulsuchdev.agendamentoapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "USUARIO")
public class Usuario {

    @Id
    @Column(name = "CONTA_USUARIO")
    private String conta;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "CONTA_VALOR")
    private BigDecimal contaValor;

    @Column(name = "SENHA")
    private String senha;

}
