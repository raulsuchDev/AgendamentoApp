package com.raulsuchdev.agendamentoapi.service.impl;

import com.raulsuchdev.agendamentoapi.service.TaxService;
import org.springframework.stereotype.Service;

import java.time.temporal.TemporalField;
import java.util.Calendar;
import java.util.Date;

@Service
public class TaxServiceImpl implements TaxService {

    @Override
    public Float getTaxaPeloIntervaloDeAgendamento(Date dataAgendamento, Date dataTransferencia) {
        return null;
    }

}
