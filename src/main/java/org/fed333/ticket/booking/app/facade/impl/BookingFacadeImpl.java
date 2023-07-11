package org.fed333.ticket.booking.app.facade.impl;

import lombok.RequiredArgsConstructor;
import org.fed333.ticket.booking.app.facade.BookingFacade;
import org.fed333.ticket.booking.app.model.entity.Event;
import org.fed333.ticket.booking.app.model.entity.Ticket;
import org.fed333.ticket.booking.app.model.entity.User;
import org.fed333.ticket.booking.app.model.entity.UserAccount;
import org.fed333.ticket.booking.app.service.EventService;
import org.fed333.ticket.booking.app.service.TicketService;
import org.fed333.ticket.booking.app.service.UserAccountService;
import org.fed333.ticket.booking.app.service.UserService;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
public class BookingFacadeImpl implements BookingFacade {

    private final UserService userService;

    private final EventService eventService;

    private final TicketService ticketService;

    private final UserAccountService accountService;

    @Override
    public Event getEventById(long eventId) {
        return eventService.getEventById(eventId);
    }

    @Override
    public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
        return eventService.findAllByTitle(title, Pageable.ofSize(pageSize).withPage(pageNum - 1));
    }

    @Override
    public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
        return eventService.getEventsForDay(day, Pageable.ofSize(pageSize).withPage(pageNum - 1));
    }

    @Override
    public Event createEvent(Event event) {
        return eventService.createEvent(event);
    }

    @Override
    public Event updateEvent(Event event) {
        return eventService.updateEvent(event);
    }

    @Override
    public boolean deleteEvent(long eventId) {
        return eventService.deleteEvent(eventId);
    }

    @Override
    public User getUserById(long userId) {
        return userService.getUserById(userId);
    }

    @Override
    public User getUserByEmail(String email) {
        return userService.getUserByEmail(email);
    }

    @Override
    public List<User> getUsersByName(String name, int pageSize, int pageNum) {
        return userService.getUsersByName(name, Pageable.ofSize(pageSize).withPage(pageNum - 1));
    }

    @Override
    public User createUser(User user) {
        return userService.createUser(user);
    }

    @Override
    public User updateUser(User user) {
        return userService.updateUser(user);
    }

    @Override
    public boolean deleteUser(long userId) {
        return userService.deleteUser(userId);
    }

    @Override
    public Ticket bookTicket(long userId, long eventId, int place, Ticket.Category category) {
        return ticketService.bookTicket(userId, eventId, place, category);
    }

    @Override
    public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
        return ticketService.getBookedTickets(user, Pageable.ofSize(pageSize).withPage(pageNum - 1));
    }

    @Override
    public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
        return ticketService.getBookedTickets(event, Pageable.ofSize(pageSize).withPage(pageNum - 1));
    }

    @Override
    public boolean cancelTicket(long ticketId) {
        return ticketService.cancelTicket(ticketId);
    }

    @Override
    public UserAccount refillAccount(UserAccount account, double money) {
        return accountService.refillAccount(account, money);
    }

}
