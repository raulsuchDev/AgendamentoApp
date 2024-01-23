package com.raulsuchdev.agendamentoapi.service;

import com.raulsuchdev.agendamentoapi.model.TaxaTransferencia;

import java.time.LocalDateTime;

public interface TaxaTransferenciaService {

    TaxaTransferencia getTaxaPorIntervaloDias(LocalDateTime dataAgendamento, LocalDateTime dataTransferencia) throws Exception;

}
