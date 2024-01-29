package com.raulsuchdev.agendamentoapi.dto;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public class BaseResponseDTO<T> {
    private HttpStatus statusCode;
    private String message;
    private T errorBody;

    public BaseResponseDTO(HttpStatus statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
