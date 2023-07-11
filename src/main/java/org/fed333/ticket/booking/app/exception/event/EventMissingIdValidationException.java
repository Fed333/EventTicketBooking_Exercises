package org.fed333.ticket.booking.app.exception.event;

public class EventMissingIdValidationException extends EventValidationException {

    public EventMissingIdValidationException() {
        super("The event object must have an id to be updated.");
    }

    public EventMissingIdValidationException(Throwable cause) {
        super("The event object must have an id to be updated.", cause);
    }
}
