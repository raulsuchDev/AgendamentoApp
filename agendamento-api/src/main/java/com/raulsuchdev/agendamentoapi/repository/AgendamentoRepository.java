package com.raulsuchdev.agendamentoapi.repository;

import com.raulsuchdev.agendamentoapi.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    List<Agendamento> findByContaOrigem(String contaOrigem);

}
