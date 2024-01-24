package com.raulsuchdev.agendamentoapi.controller;

import com.raulsuchdev.agendamentoapi.dto.ExceptionDTO;
import com.raulsuchdev.agendamentoapi.exception.IntervalLimitReachedException;
import com.raulsuchdev.agendamentoapi.exception.InvalidPasswordException;
import com.raulsuchdev.agendamentoapi.exception.InvalidTransferDateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDTO> exception(Exception e) {
        return ResponseEntity.internalServerError().body(
                new ExceptionDTO(HttpStatus.INTERNAL_SERVER_ERROR, "Erro no servidor!")
        );
    }

    @ExceptionHandler(InvalidPasswordException.class)
    public ResponseEntity<ExceptionDTO> invalidPasswordException(InvalidPasswordException e) {
        return ResponseEntity.badRequest().body(
                new ExceptionDTO(HttpStatus.BAD_REQUEST, e.getMessage())
        );
    }

    @ExceptionHandler(IntervalLimitReachedException.class)
    public ResponseEntity<ExceptionDTO> intervalLimitReachedException(IntervalLimitReachedException e) {
        return ResponseEntity.badRequest().body(
                new ExceptionDTO(HttpStatus.BAD_REQUEST, e.getMessage())
        );
    }

    @ExceptionHandler(InvalidTransferDateException.class)
    public ResponseEntity<ExceptionDTO> invalidTransferDateException(InvalidTransferDateException e) {
        return ResponseEntity.badRequest().body(
                new ExceptionDTO(HttpStatus.BAD_REQUEST, e.getMessage())
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionDTO> handleValidationExceptions(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity.badRequest().body(
                new ExceptionDTO<>(HttpStatus.BAD_REQUEST, e.getMessage(), errors)
        );
    }
}
