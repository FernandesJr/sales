package com.siganatural.sales.resources.exception;

import com.siganatural.sales.services.exceptions.ForbiddenException;
import com.siganatural.sales.services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice //Escuta as exception que são lançadas na aplicação
public class ResouceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class) //Capturando exception específica
    public ResponseEntity<StandardError> notFoundExceptionResponseEntity(ResourceNotFoundException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError error = new StandardError();
        error.setTimestamp(Instant.now());
        error.setStatus(status.value());
        error.setError("Resource not found");
        error.setMessage(e.getMessage());
        error.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(ForbiddenException.class) //Capturando exception específica
    public ResponseEntity<StandardError> notFoundExceptionResponseEntity(ForbiddenException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.FORBIDDEN;
        StandardError error = new StandardError();
        error.setTimestamp(Instant.now());
        error.setStatus(status.value());
        error.setError("Forbidden");
        error.setMessage(e.getMessage());
        error.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }
}
