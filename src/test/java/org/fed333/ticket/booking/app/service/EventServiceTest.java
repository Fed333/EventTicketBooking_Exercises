package org.fed333.ticket.booking.app.service;

import org.fed333.ticket.booking.app.exception.event.EventAlreadyExistsValidationException;
import org.fed333.ticket.booking.app.exception.event.EventMissingIdValidationException;
import org.junit.Before;
import org.junit.Test;

public class EventServiceTest {

    @Before
    public void setUp() {
    }

    @Test
    public void getEventById_shouldReturnEvent() {
    }

    @Test
    public void getEventsByTitle_shouldReturnSubList() {
    }

    @Test
    public void getEventsForDay_shouldReturnSubList() {
    }

    @Test
    public void createEvent_shouldInvokeRepository() {
    }

    @Test
    public void createEvent_shouldInvokeValidator() {
    }

    @Test(expected = EventAlreadyExistsValidationException.class)
    public void createEvent_shouldWrapAlreadyExistsValidationException() {
    }

    @Test
    public void updateEvent_shouldInvokeRepository() {
    }

    @Test
    public void updateEvent_shouldInvokeValidator() {
    }

    @Test(expected = EventAlreadyExistsValidationException.class)
    public void updateEvent_shouldWrapAlreadyExistsValidationException() {
    }

    @Test(expected = EventMissingIdValidationException.class)
    public void updateEvent_shouldWrapMissingIdValidationException() {
    }

    @Test
    public void deleteEvent_shouldInvokeRepository() {
    }
}