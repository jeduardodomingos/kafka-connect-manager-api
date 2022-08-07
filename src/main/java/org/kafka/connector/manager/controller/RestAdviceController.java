package org.kafka.connector.manager.controller;

import org.kafka.connector.manager.exception.model.ConflictException;
import org.kafka.connector.manager.exception.model.NotFoundException;
import org.kafka.connector.manager.model.response.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.UnavailableException;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RestAdviceController {

    private final Logger LOGGER = LoggerFactory.getLogger(RestAdviceController.class);

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public ErrorResponse handleNotFoundException(NotFoundException exception) {
        LOGGER.warn(NOT_FOUND.getReasonPhrase(), exception);
        return new ErrorResponse(exception.getCode().toString(), exception.getMessage(), exception.getClass().getName());
    }

    @ExceptionHandler(ConflictException.class)
    @ResponseStatus(CONFLICT)
    public ErrorResponse handleConflictException(ConflictException exception) {
        LOGGER.warn(PRECONDITION_FAILED.getReasonPhrase(), exception);
        return new ErrorResponse(exception.getCode().toString(), exception.getMessage(), exception.getClass().getName());
    }
}
