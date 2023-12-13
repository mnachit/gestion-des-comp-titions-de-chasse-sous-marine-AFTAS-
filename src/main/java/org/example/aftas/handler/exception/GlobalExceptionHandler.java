package org.example.aftas.handler.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.example.aftas.utils.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ValidationExceptionTest.class)
    public ResponseEntity<?> handleArgumentNotValid(MethodArgumentNotValidException request){
        Response<?> response = new Response<>();
        Map<String, String> errors = new HashMap<>();
        request.getBindingResult().getFieldErrors().forEach(
                e -> {
                    errors.put(e.getField(), e.getDefaultMessage());
                }
        );
        response.setErrorMap(errors);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
