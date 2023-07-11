package org.fed333.ticket.booking.app.exception;

public class MissingIdValidationException extends ValidationException {

    public MissingIdValidationException(String className) {
        super("The " + className + " object must have an id.");
    }
}
