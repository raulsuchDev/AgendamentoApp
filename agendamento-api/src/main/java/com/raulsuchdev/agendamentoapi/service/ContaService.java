package com.raulsuchdev.agendamentoapi.service;

import com.raulsuchdev.agendamentoapi.dto.ContaDTO;
import com.raulsuchdev.agendamentoapi.exception.InvalidPasswordException;

import java.math.BigDecimal;

public interface ContaService {

    void criarConta(ContaDTO criacaoContaRequest) throws InvalidPasswordException;

    BigDecimal getSaldoConta(String contaId);

}
