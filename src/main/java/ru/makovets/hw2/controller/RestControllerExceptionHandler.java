package ru.makovets.hw2.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.makovets.hw2.controller.impl.RestControllerImpl;
import ru.makovets.hw2.exceptions.ResourceNotFoundException;
import ru.makovets.hw2.exceptions.UserFieldChangeException;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice(assignableTypes = {RestControllerImpl.class})
@Slf4j
public class RestControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleEntityNotFoundException(ResourceNotFoundException exception) {
        log.error("Error on handling request", exception);
        HttpStatus status = HttpStatus.NOT_FOUND;
        Map<String, Object> error = new HashMap<>();
        error.put("code", status.value());
        error.put("message", exception.getMessage());

        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(
            {UserFieldChangeException.class, ConstraintViolationException.class, MethodArgumentNotValidException.class})
    public ResponseEntity<Map<String, Object>> handleUserCreationException(Exception exception) {
        log.error("Error on handling request", exception);
        HttpStatus status = HttpStatus.BAD_REQUEST;
        Map<String, Object> error = new HashMap<>();
        error.put("code", status.value());
        error.put("message", exception.getMessage());

        return ResponseEntity.status(status).body(error);
    }
}
