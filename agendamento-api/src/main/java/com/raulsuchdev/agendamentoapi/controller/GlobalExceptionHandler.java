package com.raulsuchdev.agendamentoapi.controller;

import com.raulsuchdev.agendamentoapi.dto.BaseResponseDTO;
import com.raulsuchdev.agendamentoapi.exception.IntervalLimitReachedException;
import com.raulsuchdev.agendamentoapi.exception.InvalidTransferDateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseResponseDTO> exception(Exception e) {
        return ResponseEntity.internalServerError().body(
                new BaseResponseDTO(HttpStatus.INTERNAL_SERVER_ERROR, "Erro no servidor!")
        );
    }

    @ExceptionHandler(IntervalLimitReachedException.class)
    public ResponseEntity<BaseResponseDTO> intervalLimitReachedException(IntervalLimitReachedException e) {
        return ResponseEntity.badRequest().body(
                new BaseResponseDTO(HttpStatus.BAD_REQUEST, e.getMessage())
        );
    }

    @ExceptionHandler(InvalidTransferDateException.class)
    public ResponseEntity<BaseResponseDTO> invalidTransferDateException(InvalidTransferDateException e) {
        return ResponseEntity.badRequest().body(
                new BaseResponseDTO(HttpStatus.BAD_REQUEST, e.getMessage())
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BaseResponseDTO> handleValidationExceptions(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity.badRequest().body(
                new BaseResponseDTO<>(HttpStatus.BAD_REQUEST, "Erro na validação da requisição!", errors)
        );
    }
}
