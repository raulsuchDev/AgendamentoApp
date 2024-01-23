package com.raulsuchdev.agendamentoapi.service.impl;

import com.raulsuchdev.agendamentoapi.dto.AgendamentoDTO;
import com.raulsuchdev.agendamentoapi.model.Agendamento;
import com.raulsuchdev.agendamentoapi.model.TaxaTransferencia;
import com.raulsuchdev.agendamentoapi.repository.AgendamentoRepository;
import com.raulsuchdev.agendamentoapi.service.AgendamentoService;
import com.raulsuchdev.agendamentoapi.service.TaxaTransferenciaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
public class AgendamentoServiceImpl implements AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;
    private final TaxaTransferenciaService taxaTransferenciaService;

    @Override
    public void criarAgendamento(AgendamentoDTO novoAgendamento) {
        try {
            Agendamento agendamento = criarNovo(novoAgendamento);
            agendamentoRepository.saveAndFlush(agendamento);
        } catch (Exception e) {
            log.error(e.getMessage(), e.fillInStackTrace());
        }
    }

    @Override
    public List<AgendamentoDTO> buscarAgendamentosPorConta(String contaId) {
        List<Agendamento> agendamentos = null;

        try {
            agendamentos = agendamentoRepository
                    .findByContaOrigem(contaId)
                    .orElseThrow();
        } catch(Exception e) {
            log.error(e.getMessage(), e.fillInStackTrace());
        }

        return agendamentos
                .stream()
                .map(AgendamentoDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void cancelarAgendamentoDeConta(Long agendamentoId, String contaId) {

    }

    @Override
    public Agendamento buscarAgendamentoPorId(Long agendamentoId) {
        return agendamentoRepository
                .findById(agendamentoId)
                .orElseThrow();
    }

    @Override
    public List<Agendamento> buscarAgendamentosPorStatus(Long agendamentoId, Integer agendamentoStatus) {
        return null;
    }

    private Agendamento criarNovo(AgendamentoDTO novoAgendamento) throws Exception {
        LocalDateTime dataAgendamento = LocalDateTime.now();
        novoAgendamento.setDataAgendamento(dataAgendamento);
        TaxaTransferencia taxaTransferencia = taxaTransferenciaService
                .getTaxaPorIntervaloDias(
                        novoAgendamento.getDataAgendamento(),
                        novoAgendamento.getDataTransferencia()
                );

        return Agendamento.criarNovo(novoAgendamento, taxaTransferencia);
    }

}
