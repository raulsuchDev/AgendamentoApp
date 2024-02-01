package com.raulsuchdev.agendamentoapi.exception;

public class InvalidTransferDateException extends RuntimeException {

    public InvalidTransferDateException(String message) {
        super(message);
    }
}
