package com.raulsuchdev.agendamentoapi.service;

import org.springframework.stereotype.Service;

import java.util.Date;

public interface TaxService {

    Float getTaxaPeloIntervaloDeAgendamento(Date dataAgendamento, Date dataTransferencia);

}
