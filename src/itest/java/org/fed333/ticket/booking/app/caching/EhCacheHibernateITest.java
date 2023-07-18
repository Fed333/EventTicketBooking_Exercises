package org.fed333.ticket.booking.app.caching;


import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
public class EhCacheHibernateITest {

    @Test
    public void eventCaching_getEventById_shouldHitAfterFirstMiss() {
    }

    @Test
    public void userCaching_getUserById_shouldHitAfterFirstMiss() {
    }

    @Test
    public void ticketCaching_getById_shouldHitAfterFirstMiss() {
    }
}
