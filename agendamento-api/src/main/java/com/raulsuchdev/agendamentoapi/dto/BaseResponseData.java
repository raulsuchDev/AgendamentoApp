package com.raulsuchdev.agendamentoapi.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class BaseResponseData<T> extends BaseResponseDTO {
    private T dataBody;

    public BaseResponseData(HttpStatus statusCode, String message, T dataBody) {
        super(statusCode, message);
        this.dataBody = dataBody;
    }
}
