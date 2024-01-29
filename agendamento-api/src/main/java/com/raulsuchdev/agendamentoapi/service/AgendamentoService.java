package com.raulsuchdev.agendamentoapi.service;

import com.raulsuchdev.agendamentoapi.dto.AgendamentoDTO;
import com.raulsuchdev.agendamentoapi.dto.NovoAgendamento;
import com.raulsuchdev.agendamentoapi.model.Agendamento;

import java.util.List;

public interface AgendamentoService {

    void criarAgendamento(NovoAgendamento novoAgendamento);

    List<AgendamentoDTO> listarAgendamentos();

}
