package com.raulsuchdev.agendamentoapi.repository;

import com.raulsuchdev.agendamentoapi.model.TaxaTransferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TaxaTransferenciaRepository extends JpaRepository<TaxaTransferencia, Integer> {

    @Query(value = "select t from TaxaTransferencia t" +
            " where :intervaloDias" +
            " between t.intervaloDiasInicio and t.intervaloDiasFinal")
    TaxaTransferencia getTaxaPorIntervaloDias(@Param("intervaloDias") Long intervaloDias);

}
