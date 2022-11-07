package com.mitocode.backenddeveloper.pruebafinal.exception;

import com.mitocode.backenddeveloper.pruebafinal.response.GenericoResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<GenericoResponse> handleError(Exception ex, WebRequest req){
        return new ResponseEntity<>(new GenericoResponse(ex.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ErrorNegocioException.class)
    public ResponseEntity<GenericoResponse> handleErrorNegocio(ErrorNegocioException ex, WebRequest req){
        return new ResponseEntity<>(new GenericoResponse(ex.getMessage(), null), HttpStatus.NOT_FOUND);
    }
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errores = ex.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.toList());

        GenericoResponse res = new GenericoResponse("Error de validación", errores);
        return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        GenericoResponse res = new GenericoResponse("URL no encontrada", null);
        return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
    }
}