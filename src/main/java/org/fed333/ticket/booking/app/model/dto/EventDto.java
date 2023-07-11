package org.fed333.ticket.booking.app.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class EventDto {

    private Long id;

    private String title;

    private String date;

    private double ticketPrice;

    private List<TicketDto> tickets;

}
