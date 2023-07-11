package org.fed333.ticket.booking.app.service;

import org.junit.Test;

public class UserAccountServiceTest {

    @Test(expected = RuntimeException.class)
    public void refillAccount_shouldThrowExceptionWhenMoneyIsNegative() {
    }

    @Test
    public void refillAccount_shouldSetMoneyToAccount() {
    }

    @Test
    public void refillAccount_shouldInvokeUserAccountRepository() {

    }
}