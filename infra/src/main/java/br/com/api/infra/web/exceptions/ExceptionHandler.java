package br.com.api.infra.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.api.exceptions.EntityNotFoundException;
import br.com.api.exceptions.UsernameUniqueValidationException;
import br.com.api.exceptions.ValidationException;
import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(AccessDeniedException.class) 
    public ResponseEntity<ErrorMessage> accessDeniedException(AccessDeniedException ex, HttpServletRequest request) {
        return ResponseEntity
               .status(HttpStatus.FORBIDDEN)
               .contentType(MediaType.APPLICATION_JSON)
               .body(new ErrorMessage(request, HttpStatus.FORBIDDEN, ex.getMessage()));                                                                                                                 
    }
    
    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class) 
    public ResponseEntity<ErrorMessage> methodArgumentNotValidException(MethodArgumentNotValidException exception, HttpServletRequest request, BindingResult result) {
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .contentType(MediaType.APPLICATION_JSON)
            .body(new ErrorMessage(request, HttpStatus.BAD_REQUEST, "Campo(s) inválido(s)", result));
    }
    
    @org.springframework.web.bind.annotation.ExceptionHandler(EntityNotFoundException.class) 
    public ResponseEntity<ErrorMessage> entityNotFoundException(RuntimeException ex, HttpServletRequest request) {
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .contentType(MediaType.APPLICATION_JSON)
            .body(new ErrorMessage(request, HttpStatus.NOT_FOUND, ex.getMessage()));
    }
    
    @org.springframework.web.bind.annotation.ExceptionHandler(UsernameUniqueValidationException.class) 
    public ResponseEntity<ErrorMessage> usernameUniqueValidationException(RuntimeException ex, HttpServletRequest request) {
        return ResponseEntity
            .status(HttpStatus.CONFLICT)
            .contentType(MediaType.APPLICATION_JSON)
            .body(new ErrorMessage(request, HttpStatus.CONFLICT, ex.getMessage()));
    }
    
    @org.springframework.web.bind.annotation.ExceptionHandler(ValidationException.class) 
    public ResponseEntity<ErrorMessage> validationException(RuntimeException ex, HttpServletRequest request) {
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .contentType(MediaType.APPLICATION_JSON)
            .body(new ErrorMessage(request, HttpStatus.BAD_REQUEST, ex.getMessage()));
    }

}