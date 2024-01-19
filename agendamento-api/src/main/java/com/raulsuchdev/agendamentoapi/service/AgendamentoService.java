package com.raulsuchdev.agendamentoapi.service;

import com.raulsuchdev.agendamentoapi.dto.AgendamentoDTO;
import com.raulsuchdev.agendamentoapi.model.Agendamento;

import java.util.List;

public interface AgendamentoService {

    void registrarAgendamento(AgendamentoDTO agendamento);

    List<AgendamentoDTO> getUsuarioAgendamento(String contaUsuario);

    void alterarStatusAgendamento(Long agendamentoId, Integer agendamentoStatus);

}
