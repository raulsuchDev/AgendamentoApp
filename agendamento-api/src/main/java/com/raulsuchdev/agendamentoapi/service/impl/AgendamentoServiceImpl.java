package com.raulsuchdev.agendamentoapi.service.impl;

import com.raulsuchdev.agendamentoapi.dto.AgendamentoDTO;
import com.raulsuchdev.agendamentoapi.dto.NovoAgendamento;
import com.raulsuchdev.agendamentoapi.exception.InvalidTransferDateException;
import com.raulsuchdev.agendamentoapi.exception.NovoAgendamentoInvalidValueException;
import com.raulsuchdev.agendamentoapi.model.Agendamento;
import com.raulsuchdev.agendamentoapi.model.TaxaTransferencia;
import com.raulsuchdev.agendamentoapi.repository.AgendamentoRepository;
import com.raulsuchdev.agendamentoapi.service.AgendamentoService;
import com.raulsuchdev.agendamentoapi.service.TaxaTransferenciaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Slf4j
@Service
public class AgendamentoServiceImpl implements AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;
    private final TaxaTransferenciaService taxaTransferenciaService;

    @Override
    public void criarAgendamento(NovoAgendamento novoAgendamento) {
        try {
            Agendamento agendamento = criarNovo(novoAgendamento);
            agendamentoRepository.saveAndFlush(agendamento);
        } catch (Exception e) {
            log.error(e.getMessage(), e.fillInStackTrace());
        }
    }

    @Override
    public List<AgendamentoDTO> listarAgendamentos() {
        return agendamentoRepository.findAll()
                .stream()
                .map(agendamento -> AgendamentoDTO.fromEntity(agendamento))
                .collect(Collectors.toList());
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

    private Agendamento criarNovo(NovoAgendamento novoAgendamento) throws Exception {
        LocalDate dataAgendamento = LocalDate.now();
        validateTransferDate(dataAgendamento, novoAgendamento.getDataTransferencia());
        TaxaTransferencia taxaTransferencia = taxaTransferenciaService
                .getTaxaPorIntervaloDias(
                        dataAgendamento,
                        novoAgendamento.getDataTransferencia()
                );

        return Agendamento.criarNovo(novoAgendamento, dataAgendamento, taxaTransferencia);
    }

    private void validateTransferDate(
            LocalDate dataAgendamento,
            LocalDate dataTransferencia) throws InvalidTransferDateException {
        if (dataTransferencia.isBefore(dataAgendamento)) {
            throw new InvalidTransferDateException("A data de agendamento não pode ser antes de hoje!");
        }
    }

}
