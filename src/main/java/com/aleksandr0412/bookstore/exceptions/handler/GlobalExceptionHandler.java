package com.aleksandr0412.bookstore.exceptions.handler;

import com.aleksandr0412.bookstore.controller.dto.ResponseError;
import com.aleksandr0412.bookstore.exceptions.EmptyOrderException;
import com.aleksandr0412.bookstore.exceptions.IncorrectEmailException;
import com.aleksandr0412.bookstore.exceptions.IncorrectSumException;
import com.aleksandr0412.bookstore.exceptions.ResourceNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.UUID;

@RestControllerAdvice(basePackages = "com.aleksandr0412.bookstore.controller")
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger log = LogManager.getLogger(GlobalExceptionHandler.class.getName());

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ResponseError> illegalArgumentException(IllegalArgumentException exception) {
        log.debug(exception.getLocalizedMessage(), exception);
        ResponseError error = new ResponseError(
                UUID.randomUUID(),
                "illegalArgumentException",
                exception.getLocalizedMessage(),
                "mySystem"
        );
        return new ResponseEntity<>(error, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResponseError> resourceNotFoundException(ResourceNotFoundException exception) {
        log.debug(exception.getLocalizedMessage(), exception);
        ResponseError error = new ResponseError(
                UUID.randomUUID(),
                "resourceNotFoundException",
                exception.getLocalizedMessage(),
                "mySystem"
        );
        return new ResponseEntity<>(error, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmptyOrderException.class)
    public ResponseEntity<ResponseError> emptyOrderException(EmptyOrderException exception) {
        log.debug(exception.getLocalizedMessage(), exception);
        ResponseError error = new ResponseError(
                UUID.randomUUID(),
                "emptyOrderException",
                exception.getLocalizedMessage(),
                "mySystem"
        );
        return new ResponseEntity<>(error, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IncorrectEmailException.class)
    public ResponseEntity<ResponseError> incorrectEmailException(IncorrectEmailException exception) {
        log.debug(exception.getLocalizedMessage(), exception);
        ResponseError error = new ResponseError(
                UUID.randomUUID(),
                "incorrectEmailException",
                exception.getLocalizedMessage(),
                "mySystem"
        );
        return new ResponseEntity<>(error, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IncorrectSumException.class)
    public ResponseEntity<ResponseError> incorrectSumException(IncorrectSumException exception) {
        log.debug(exception.getLocalizedMessage(), exception);
        ResponseError error = new ResponseError(
                UUID.randomUUID(),
                "incorrectSumException",
                exception.getLocalizedMessage(),
                "mySystem"
        );
        return new ResponseEntity<>(error, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ResponseError> runtimeException(RuntimeException exception) {
        log.debug(exception.getLocalizedMessage(), exception);
        ResponseError error = new ResponseError(
                UUID.randomUUID(),
                "unknown",
                exception.getLocalizedMessage(),
                "mySystem"
        );
        return new ResponseEntity<>(error, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseError> runtimeException(Exception exception) {
        log.debug(exception.getLocalizedMessage(), exception);
        ResponseError error = new ResponseError(
                UUID.randomUUID(),
                "unknown",
                "Что-то пошло не так",
                "mySystem"
        );
        return new ResponseEntity<>(error, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}