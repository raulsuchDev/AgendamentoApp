package com.raulsuchdev.agendamentoapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
@Setter
public class BaseResponseDTO {
    private HttpStatus statusCode;
    private String message;
}
