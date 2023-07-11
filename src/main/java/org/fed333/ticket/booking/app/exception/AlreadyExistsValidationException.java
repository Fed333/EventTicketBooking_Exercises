package org.fed333.ticket.booking.app.exception;

import lombok.Getter;

@Getter
public class AlreadyExistsValidationException extends ValidationException {

    private final String id;

    public AlreadyExistsValidationException(String className, String id) {
        super("The " + className + " object with id " + id + " already exists");
        this.id = id;
    }

    public AlreadyExistsValidationException(String message, AlreadyExistsValidationException cause) {
        super(message, cause);
        this.id = cause.getId();
    }
}
