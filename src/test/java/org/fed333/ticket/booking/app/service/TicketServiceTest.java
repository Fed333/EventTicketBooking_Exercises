package org.fed333.ticket.booking.app.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Pageable;

public class TicketServiceTest {

    @Before
    public void setUp() {
    }

    @Test(expected = RuntimeException.class)
    public void bookTicket_ifUserNotExistsShouldThrowException() {
    }

    @Test(expected = RuntimeException.class)
    public void bookTicket_ifEventNotExistsShouldThrowException() {
    }

    @Test
    public void bookTicket_ifOkShouldInvokeRepository() {
    }

    @Test
    public void getBookedTicketsByUser_shouldReturnTickets() {
    }

    @Test
    public void getBookedTicketsByUser_shouldInvokeRepository() {
    }

    @Test
    public void getBookedTicketsByEvent_shouldReturnTickets() {
    }

    @Test
    public void getBookedTicketsByEvent_shouldInvokeRepository() {
    }

    @Test
    public void cancelTicket_shouldCancel() {
    }
}