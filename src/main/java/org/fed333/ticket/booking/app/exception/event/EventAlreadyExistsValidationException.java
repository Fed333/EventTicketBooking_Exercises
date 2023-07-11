package org.fed333.ticket.booking.app.exception.event;

import lombok.Getter;
import org.fed333.ticket.booking.app.exception.AlreadyExistsValidationException;

@Getter
public class EventAlreadyExistsValidationException extends EventValidationException {

    private final String id;

    public EventAlreadyExistsValidationException(String id) {
        super("The event object with id " + id + " already exists");
        this.id = id;
    }

    public EventAlreadyExistsValidationException(AlreadyExistsValidationException cause) {
        super(cause);
        this.id = cause.getId();
    }
    public EventAlreadyExistsValidationException(String message, AlreadyExistsValidationException cause) {
        super(message, cause);
        this.id = cause.getId();
    }
}