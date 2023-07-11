package org.fed333.ticket.booking.app.model.dto;

import lombok.Builder;
import lombok.Data;
import org.fed333.ticket.booking.app.model.entity.Ticket;

@Data
@Builder
public class TicketDto {

    private Long id;

    private Ticket.Category category;

    private int place;

    private boolean cancelled;

}
