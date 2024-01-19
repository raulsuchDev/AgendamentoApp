package com.raulsuchdev.agendamentoapi.service.impl;

import com.raulsuchdev.agendamentoapi.dto.AgendamentoDTO;
import com.raulsuchdev.agendamentoapi.model.Agendamento;
import com.raulsuchdev.agendamentoapi.repository.AgendamentoRepository;
import com.raulsuchdev.agendamentoapi.service.AgendamentoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class AgendamentoServiceImpl implements AgendamentoService {

    private final ModelMapper modelMapper;
    private final AgendamentoRepository agendamentoRepository;

    @Override
    public void registrarAgendamento(AgendamentoDTO agendamentoRequest) {
        try {
            Agendamento agendamento = modelMapper.map(agendamentoRequest, Agendamento.class);
            agendamentoRepository.saveAndFlush(agendamento);
        } catch (Exception e) {
            log.error(e.getMessage(), e.fillInStackTrace());
        }
    }

    @Override
    public List<AgendamentoDTO> getUsuarioAgendamento(String contaUsuario) {
        List<Agendamento> agendamentos = null;

        try {
            agendamentos = agendamentoRepository.findByContaOrigem(contaUsuario);
        } catch(Exception e) {
            log.error(e.getMessage(), e.fillInStackTrace());
        }

        return agendamentos
                .stream()
                .map(AgendamentoDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void alterarStatusAgendamento(Long agendamentoId, Integer agendamentoStatus) {

    }

}
