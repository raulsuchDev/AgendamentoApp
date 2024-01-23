package com.raulsuchdev.agendamentoapi.repository;

import com.raulsuchdev.agendamentoapi.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    Optional<List<Agendamento>> findByContaOrigem(String contaOrigem);

}
