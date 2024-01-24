package com.raulsuchdev.agendamentoapi.dto;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public class ExceptionDTO<T> {
    private HttpStatus statusCode;
    private String message;
    private T errorBody;

    public ExceptionDTO(HttpStatus statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
