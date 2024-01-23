package com.raulsuchdev.agendamentoapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContaDTO {
    private String id;
    private String nomeProprietario;
    private BigDecimal saldo;
    private String senha;
}
