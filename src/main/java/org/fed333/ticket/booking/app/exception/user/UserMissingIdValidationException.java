package org.fed333.ticket.booking.app.exception.user;

public class UserMissingIdValidationException extends UserValidationException {

    public UserMissingIdValidationException() {
        super("The user object must have an id to be updated.");
    }

    public UserMissingIdValidationException(Throwable cause) {
        super("The user object must have an id to be updated.", cause);
    }
}
