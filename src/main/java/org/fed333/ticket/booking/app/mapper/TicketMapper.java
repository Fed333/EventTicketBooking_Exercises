package org.fed333.ticket.booking.app.mapper;

import org.fed333.ticket.booking.app.model.dto.TicketDto;
import org.fed333.ticket.booking.app.model.entity.Ticket;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TicketMapper {

    public TicketDto toDto(Ticket ticket) {
        return map(ticket);
    }

    public List<TicketDto> toDtos(List<Ticket> tickets) {
        return Optional.ofNullable(tickets).orElseGet(Collections::emptyList).stream().map(this::map).collect(Collectors.toList());
    }

    private TicketDto map(Ticket ticket) {
        return map(ticket, (b) -> b);
    }

    private TicketDto map(Ticket ticket, Function<TicketDto.TicketDtoBuilder, TicketDto.TicketDtoBuilder> build) {
        if (Objects.isNull(ticket)) {
            return null;
        }
        return build.apply(TicketDto.builder()
                .id(ticket.getId())
                .category(ticket.getCategory())
                .place(ticket.getPlace())
                .cancelled(ticket.isCancelled())).build();
    }


}
