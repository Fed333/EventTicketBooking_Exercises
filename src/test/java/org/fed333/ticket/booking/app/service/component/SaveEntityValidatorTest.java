package org.fed333.ticket.booking.app.service.component;

import org.junit.Before;
import org.junit.Test;

public class SaveEntityValidatorTest {

    @Before
    public void setUp() {
    }

    @Test(expected = RuntimeException.class)
    public void validateCreate_ifExistsShouldThrowException() {
    }

    @Test
    public void validateCreate_ifNotExistsShouldNotThrowException() {
    }

    @Test(expected = RuntimeException.class)
    public void validateUpdate_ifNullIdShouldThrowException() {
    }

    @Test(expected = RuntimeException.class)
    public void validateUpdate_ifMissingShouldThrowException() {
    }

    @Test
    public void validateUpdate_ifPresentShouldNotThrowException() {
    }
}