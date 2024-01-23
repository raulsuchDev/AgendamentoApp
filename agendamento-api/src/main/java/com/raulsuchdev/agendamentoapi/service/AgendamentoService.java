package com.raulsuchdev.agendamentoapi.service;

import com.raulsuchdev.agendamentoapi.dto.AgendamentoDTO;
import com.raulsuchdev.agendamentoapi.model.Agendamento;

import java.util.List;

public interface AgendamentoService {

    void criarAgendamento(AgendamentoDTO novoAgendamento);

    List<AgendamentoDTO> buscarAgendamentosPorConta(String contaId);

    void cancelarAgendamentoDeConta(Long agendamentoId, String contaId);

    Agendamento buscarAgendamentoPorId(Long agendamentoId);

    List<Agendamento> buscarAgendamentosPorStatus(Long agendamentoId, Integer agendamentoStatus);

}
