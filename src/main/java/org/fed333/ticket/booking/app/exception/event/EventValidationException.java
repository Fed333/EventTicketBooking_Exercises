package org.fed333.ticket.booking.app.exception.event;

import org.fed333.ticket.booking.app.exception.ValidationException;

public class EventValidationException extends ValidationException {

    public EventValidationException() {
        super();
    }

    public EventValidationException(String message) {
        super(message);
    }

    public EventValidationException(Throwable cause) {
        super(cause);
    }

    public EventValidationException(String message, Throwable cause) {
        super(message, cause);
    }

}
