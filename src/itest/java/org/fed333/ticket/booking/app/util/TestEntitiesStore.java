package org.fed333.ticket.booking.app.util;

import org.fed333.ticket.booking.app.model.entity.Event;
import org.fed333.ticket.booking.app.model.entity.Ticket;
import org.fed333.ticket.booking.app.model.entity.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Class designed for encapsulating expected test entity data from {@code resources/init-data/storage.json} <br>
 * Please use a constructor initializing approach for the source data class. So that corresponding object would be created directly.
 * */
public class TestEntitiesStore {

    private final Map<Long, Event> testEvents;

    private final Map<Long, User> testUsers;

    private final Map<Long, Ticket> testTickets;

    public TestEntitiesStore() {
        //TODO paste objects creation logic here, don't get the data from storage.json
        testEvents = new HashMap<>();

        testUsers = new HashMap<>();

        testTickets = new HashMap<>();
    }
}