package com.raulsuchdev.agendamentoapi.service;

import com.raulsuchdev.agendamentoapi.model.TaxaTransferencia;

import java.time.LocalDate;

public interface TaxaTransferenciaService {

    TaxaTransferencia getTaxaPorIntervaloDias(LocalDate dataAgendamento, LocalDate dataTransferencia) throws Exception;

}
