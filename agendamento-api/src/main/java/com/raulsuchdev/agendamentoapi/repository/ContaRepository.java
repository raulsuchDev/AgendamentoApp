package com.raulsuchdev.agendamentoapi.repository;

import com.raulsuchdev.agendamentoapi.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface ContaRepository /*extends JpaRepository<Conta, String>*/ {

    /*@Query(value = "select c.saldo from Conta c where c.id = :contaId")
    BigDecimal getSaldoConta(@Param("contaId") String contaId);*/

}
