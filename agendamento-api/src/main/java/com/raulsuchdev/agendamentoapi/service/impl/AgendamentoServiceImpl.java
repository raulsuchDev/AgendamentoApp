package com.raulsuchdev.agendamentoapi.service.impl;

import com.raulsuchdev.agendamentoapi.dto.AgendamentoDTO;
import com.raulsuchdev.agendamentoapi.dto.NovoAgendamento;
import com.raulsuchdev.agendamentoapi.exception.ContasIguaisException;
import com.raulsuchdev.agendamentoapi.exception.InvalidTransferDateException;
import com.raulsuchdev.agendamentoapi.exception.NovoAgendamentoInvalidValueException;
import com.raulsuchdev.agendamentoapi.model.Agendamento;
import com.raulsuchdev.agendamentoapi.model.TaxaTransferencia;
import com.raulsuchdev.agendamentoapi.repository.AgendamentoRepository;
import com.raulsuchdev.agendamentoapi.service.AgendamentoService;
import com.raulsuchdev.agendamentoapi.service.TaxaTransferenciaService;
import com.raulsuchdev.agendamentoapi.utils.DateUtil;
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
            log.info("Service:" + novoAgendamento.getDataTransferencia().toString());
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

    private Agendamento criarNovo(NovoAgendamento novoAgendamento) throws Exception {
        LocalDate dataAgendamento = LocalDate.now();
        validateContas(novoAgendamento.getContaOrigem(), novoAgendamento.getContaDestino());
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

    private void validateContas(String contaOrigem, String contaDestino) throws ContasIguaisException {
        if(contaOrigem.equals(contaDestino)) {
            throw new ContasIguaisException();
        }
    }

}
