package org.fed333.ticket.booking.app.controller;

import org.fed333.ticket.booking.app.exception.event.EventAlreadyExistsValidationException;
import org.fed333.ticket.booking.app.exception.event.EventMissingIdValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestControllerAdvice
public class EventControllerAdvice {

    @ExceptionHandler(EventAlreadyExistsValidationException.class)
    public ResponseEntity<?> handleAlreadyExistsEvent(EventAlreadyExistsValidationException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Stream.of(new Object[][] {
                        { "message", e.getMessage() },
                        { "id", e.getId() }
                }).collect(Collectors.toMap(a -> a[0], a -> a[1]))
        );
    }

    @ExceptionHandler(EventMissingIdValidationException.class)
    public ResponseEntity<?> handleMissingIdEvent(EventMissingIdValidationException e) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(Stream.of(new Object[][] {
                        { "message", e.getMessage() }
                }).collect(Collectors.toMap(a -> a[0], a -> a[1]))
        );
    }
}
