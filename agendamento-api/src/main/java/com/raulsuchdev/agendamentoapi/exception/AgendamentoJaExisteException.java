package com.raulsuchdev.agendamentoapi.exception;

public class AgendamentoJaExisteException extends RuntimeException {
    public AgendamentoJaExisteException() {
        super("Já existe uma agendamento com essas informações!");
    }
}
