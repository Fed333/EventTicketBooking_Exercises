package org.fed333.ticket.booking.app.service;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.fed333.ticket.booking.app.model.entity.Event;
import org.fed333.ticket.booking.app.model.entity.Ticket;
import org.fed333.ticket.booking.app.model.entity.User;
import org.fed333.ticket.booking.app.model.entity.UserAccount;
import org.fed333.ticket.booking.app.repository.EventRepository;
import org.fed333.ticket.booking.app.repository.TicketRepository;
import org.fed333.ticket.booking.app.repository.UserRepository;
import org.fed333.ticket.booking.app.service.component.SaveEntityValidator;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;

    private final UserRepository userRepository;

    private final EventRepository eventRepository;

    private final UserAccountService accountService;

    @Setter
    private SaveEntityValidator<Ticket, Long> saveTicketValidator;

    private void init() {
        saveTicketValidator.setRepository(ticketRepository);
    }

    public Ticket getById(Long ticketId) {
        return ticketRepository.findById(ticketId).orElse(null);
    }

    public Ticket bookTicket(long userId, long eventId, int place, Ticket.Category category) {
        User user = userRepository.findById(userId).orElse(null);
        Event event = eventRepository.findById(eventId).orElse(null);

        if (Objects.isNull(user)) {
            throw new RuntimeException("No found user with id " + userId + " to create a ticket.");
        }
        if (Objects.isNull(event)) {
            throw new RuntimeException("No found event with id " + eventId + " to create a ticket.");
        }
        UserAccount account = user.getAccount();
        if (Objects.isNull(account) || event.getTicketPrice() > account.getMoney()) {
            throw new RuntimeException("Cannot book event {id: " + event.getId() + "} for user {id: " + user.getId() + "}. Not enough money!");
        }

        accountService.refillAccount(account, account.getMoney() - event.getTicketPrice());

        Ticket ticket = Ticket.builder()
                .user(user)
                .event(event)
                .place(place)
                .category(category).build();

        ticketRepository.save(ticket);
        log.info("Ticket {} has been booked successfully.", ticket);
        return ticket;
    }

    public List<Ticket> getBookedTickets(User user, Pageable page) {
        return ticketRepository.findAllByUserId(user.getId(), page);
    }

    public List<Ticket> getBookedTickets(Event event, Pageable page) {
        return ticketRepository.findAllByEventId(event.getId(), page);
    }

    public boolean cancelTicket(long ticketId) {
        Ticket ticketToCancel = ticketRepository.findById(ticketId).orElseThrow(NoSuchElementException::new);
        ticketToCancel.setCancelled(true);
        ticketRepository.save(ticketToCancel);
        return ticketToCancel.isCancelled();
    }

}
