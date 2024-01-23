package com.raulsuchdev.agendamentoapi.util;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

public class CustomIdGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        return gerarIdUnico();
    }

    private String gerarIdUnico() {
        String timestampPart = String.valueOf(Instant.now().toEpochMilli());
        String uuidPart = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 6);

        return timestampPart.concat(uuidPart);
    }
}
