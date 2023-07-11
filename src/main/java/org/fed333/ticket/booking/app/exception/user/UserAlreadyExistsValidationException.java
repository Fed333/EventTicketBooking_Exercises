package org.fed333.ticket.booking.app.exception.user;

import org.fed333.ticket.booking.app.exception.AlreadyExistsValidationException;

public class UserAlreadyExistsValidationException extends UserValidationException {

    private final String id;

    public UserAlreadyExistsValidationException(String id) {
        super("The user object with id " + id + " already exists");
        this.id = id;
    }

    public UserAlreadyExistsValidationException(AlreadyExistsValidationException cause) {
        super(cause);
        this.id = cause.getId();
    }
    public UserAlreadyExistsValidationException(String message, AlreadyExistsValidationException cause) {
        super(message, cause);
        this.id = cause.getId();
    }
}