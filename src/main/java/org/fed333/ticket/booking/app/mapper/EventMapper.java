package org.fed333.ticket.booking.app.mapper;

import lombok.RequiredArgsConstructor;
import org.fed333.ticket.booking.app.model.dto.EventDto;
import org.fed333.ticket.booking.app.model.entity.Event;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class EventMapper {

    private final TicketMapper ticketMapper;

    public EventDto toDto(Event event) {
        return map(event, (b) -> b.tickets(ticketMapper.toDtos(event.getTickets())));
    }

    public List<EventDto> toDtos(List<Event> events) {
        return events.stream().map(this::map).collect(Collectors.toList());
    }

    private EventDto map(Event event) {
        return map(event, (b) -> b);
    }

    private EventDto map(Event event, Function<EventDto.EventDtoBuilder, EventDto.EventDtoBuilder> build) {
        if (Objects.isNull(event)) {
            return null;
        }
        return build.apply(EventDto.builder())
                .id(event.getId())
                .title(event.getTitle())
                .date(new SimpleDateFormat("yyyy-MM-dd").format(event.getDate()))
                .ticketPrice(event.getTicketPrice()).build();
    }

}
