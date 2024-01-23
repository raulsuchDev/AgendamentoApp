package com.raulsuchdev.agendamentoapi.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

/*@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "AGENDAMENTO_STATUS")*/
public class AgendamentoStatus {
    // TODO Implementar status de agendamentos
    /*@Id
    @Column(name = "ID")*/
    private Integer id;

    /*@Column(name = "DESCRICAO")*/
    private String descricao;

}
