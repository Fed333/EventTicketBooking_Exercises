package org.fed333.ticket.booking.app.service;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.fed333.ticket.booking.app.exception.AlreadyExistsValidationException;
import org.fed333.ticket.booking.app.exception.MissingIdValidationException;
import org.fed333.ticket.booking.app.exception.event.EventAlreadyExistsValidationException;
import org.fed333.ticket.booking.app.exception.event.EventMissingIdValidationException;
import org.fed333.ticket.booking.app.model.entity.Event;
import org.fed333.ticket.booking.app.repository.EventRepository;
import org.fed333.ticket.booking.app.service.component.SaveEntityValidator;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    @Setter
    private SaveEntityValidator<Event, Long> saveEventValidator;

    private void init() {
        saveEventValidator.setRepository(eventRepository);
    }

    public List<Event> getEvents() {
        return eventRepository.findAll();
    }

    public Event getEventById(Long id) {
        return eventRepository.findById(id).orElse(null);
    }

    public List<Event> findAllByTitle(String title, Pageable page) {
        return eventRepository.findAllByTitle(title, page);
    }

    public List<Event> getEventsForDay(Date day, Pageable page) {
        return eventRepository.findAllByDay(day, page);
    }

    public Event createEvent(Event event) {
        try {
            saveEventValidator.validateCreate(event);
        } catch (AlreadyExistsValidationException e) {
            throw new EventAlreadyExistsValidationException(e);
        }

        Event saved = eventRepository.save(event);
        log.info("Event {} has been created successfully.", saved);
        return saved;
    }

    public Event updateEvent(Event event) {
        try {
            saveEventValidator.validateUpdate(event);
        } catch (MissingIdValidationException e) {
            throw new EventMissingIdValidationException(e);
        } catch (AlreadyExistsValidationException e) {
            throw new EventAlreadyExistsValidationException(e);
        }

        Event saved = eventRepository.save(event);
        log.info("Event {} has been updated successfully.", saved);
        return saved;
    }

    public boolean deleteEvent(long eventId) {
        Optional<Event> optionalEvent = eventRepository.findById(eventId);
        if (optionalEvent.isPresent()){
            eventRepository.deleteById(eventId);
            log.info("Event {} was deleted successfully.", optionalEvent.get());
            return true;
        }
        return false;
    }

}
