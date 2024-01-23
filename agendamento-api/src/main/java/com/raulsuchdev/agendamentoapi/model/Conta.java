package com.raulsuchdev.agendamentoapi.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

/*@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "CONTA")*/
public class Conta {
// TODO Implementar autenticação por conta
    /*@Id
    @GeneratedValue(generator = "custom-id-generator")
    @GenericGenerator(name = "custom-id-generator", strategy = "com.raulsuchdev.agendamentoapi.util.CustomIdGenerator")
    @Column(name = "ID", length = 10)*/
    private String id;

    //@Column(name = "NOME_PROPRIETARIO")
    private String nomeProprietario;

    //@Column(name = "SALDO")
    private BigDecimal saldo;

    //@Column(name = "SENHA")
    private String senha;

    /*public static Conta novaConta(String nomeProprietario, String senha) {
        return Conta.builder()
                .nomeProprietario(nomeProprietario)
                .senha(senha)
                .saldo(BigDecimal.valueOf(5000.00))
                .build();
    }*/
}
