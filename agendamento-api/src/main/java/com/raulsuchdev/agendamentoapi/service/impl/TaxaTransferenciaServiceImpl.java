package com.raulsuchdev.agendamentoapi.service.impl;

import com.raulsuchdev.agendamentoapi.exception.IntervalLimitReachedException;
import com.raulsuchdev.agendamentoapi.model.TaxaTransferencia;
import com.raulsuchdev.agendamentoapi.repository.TaxaTransferenciaRepository;
import com.raulsuchdev.agendamentoapi.service.TaxaTransferenciaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@RequiredArgsConstructor
@Slf4j
@Service
public class TaxaTransferenciaServiceImpl implements TaxaTransferenciaService {

    private final TaxaTransferenciaRepository taxaTransferenciaRepository;

    @Override
    public TaxaTransferencia getTaxaPorIntervaloDias(
        LocalDate dataAgendamento,
        LocalDate dataTransferencia
    ) throws Exception {
        Long intervaloDias = calcularIntervaloEmDias(dataAgendamento, dataTransferencia);
        TaxaTransferencia taxaTransferencia = taxaTransferenciaRepository.getTaxaPorIntervaloDias(intervaloDias);

        return taxaTransferencia;
    }

    private Long calcularIntervaloEmDias(LocalDate dataAgendamento, LocalDate dataTransferencia) throws IntervalLimitReachedException {
        Long diferencaDeDias = ChronoUnit.DAYS.between(dataAgendamento, dataTransferencia);

        if (diferencaDeDias.longValue() > 50L) {
            throw new IntervalLimitReachedException("Não há taxa aplicável para esse período de agendamento!");
        }

        return diferencaDeDias;
    }

}
