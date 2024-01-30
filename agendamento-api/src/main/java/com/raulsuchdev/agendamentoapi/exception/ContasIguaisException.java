package com.raulsuchdev.agendamentoapi.exception;

public class ContasIguaisException extends RuntimeException {
    public ContasIguaisException() {
        super("A conta de origem deve ser diferente da conta de destino!");
    }
}
