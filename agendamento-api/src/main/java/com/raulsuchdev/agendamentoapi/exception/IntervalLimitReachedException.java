package com.raulsuchdev.agendamentoapi.exception;

public class IntervalLimitReachedException extends RuntimeException {

    public IntervalLimitReachedException(String message) {
        super(message);
    }
}
