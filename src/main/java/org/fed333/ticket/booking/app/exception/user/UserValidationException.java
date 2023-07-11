package org.fed333.ticket.booking.app.exception.user;

import org.fed333.ticket.booking.app.exception.ValidationException;

public class UserValidationException extends ValidationException {

    public UserValidationException() {
        super();
    }

    public UserValidationException(String message) {
        super(message);
    }

    public UserValidationException(Throwable cause) {
        super(cause);
    }

    public UserValidationException(String message, Throwable cause) {
        super(message, cause);
    }

}
