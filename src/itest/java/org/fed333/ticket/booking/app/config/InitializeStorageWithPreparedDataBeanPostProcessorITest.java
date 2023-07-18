package org.fed333.ticket.booking.app.config;


import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
public class InitializeStorageWithPreparedDataBeanPostProcessorITest {

    @Test
    public void eventRepository_shouldBePreInitializedWithJSON() {
    }

    @Test
    public void userRepository_shouldBePreInitializedWithJSON() {
    }

    @Test
    public void ticketRepository_shouldBePreInitializedWithJSON() {
    }
}