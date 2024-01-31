package com.raulsuchdev.agendamentoapi.repository;

import com.raulsuchdev.agendamentoapi.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
}
