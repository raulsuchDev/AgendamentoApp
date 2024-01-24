package com.raulsuchdev.agendamentoapi.exception;

public class IntervalLimitReachedException extends Exception {

    public IntervalLimitReachedException(String message) {
        super(message);
    }
}
