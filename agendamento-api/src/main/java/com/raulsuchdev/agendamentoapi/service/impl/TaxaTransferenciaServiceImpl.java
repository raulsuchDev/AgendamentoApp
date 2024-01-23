package com.raulsuchdev.agendamentoapi.service.impl;

import com.raulsuchdev.agendamentoapi.model.TaxaTransferencia;
import com.raulsuchdev.agendamentoapi.repository.TaxaTransferenciaRepository;
import com.raulsuchdev.agendamentoapi.service.TaxaTransferenciaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Slf4j
@Service
public class TaxaTransferenciaServiceImpl implements TaxaTransferenciaService {

    private final TaxaTransferenciaRepository taxaTransferenciaRepository;

    @Override
    public TaxaTransferencia getTaxaPorIntervaloDias(
        LocalDateTime dataAgendamento,
        LocalDateTime dataTransferencia
    ) throws Exception {
        Long intervaloDias = calcularIntervaloEmDias(dataAgendamento, dataTransferencia);
        TaxaTransferencia taxaTransferencia = taxaTransferenciaRepository.getTaxaPorIntervaloDias(intervaloDias);

        return taxaTransferencia;
    }

    private Long calcularIntervaloEmDias(LocalDateTime dataAgendamento, LocalDateTime dataTransferencia) throws Exception {
        Duration diferencaDeData = Duration.between(dataAgendamento, dataTransferencia);
        Long diferencaDeDias = diferencaDeData.toDays();

        if (diferencaDeDias.longValue() > 50L) {
            throw new Exception("Intervalo de dias para agendamento maior que o permitido!");
        }

        return diferencaDeDias;
    }

}
