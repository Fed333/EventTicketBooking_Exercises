package org.fed333.ticket.booking.app.service;

import org.fed333.ticket.booking.app.exception.user.UserAlreadyExistsValidationException;
import org.fed333.ticket.booking.app.exception.user.UserMissingIdValidationException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

public class UserServiceTest {

    @Before
    public void setUp() {
    }

    @Test
    public void getUserById_shouldReturnFromRepository() {
    }

    @Test
    public void getUserByEmail_shouldReturnFromRepository() {
    }

    @Test
    public void getUserByEmail_ifMissingShouldReturnNull() {
    }

    @Test(expected = RuntimeException.class)
    public void getUserByEmail_ifMoreThanOneUserFoundShouldThrowException() {
    }

    @Test
    public void getUsersByName_shouldReturnFromRepository() {
    }

    @Test
    public void createUser_shouldInvokeValidator() {
    }

    @Test
    public void createUser_shouldInvokeRepository() {
    }

    @Test(expected = UserAlreadyExistsValidationException.class)
    public void createUser_shouldWrapAlreadyExistsValidationException() {
    }

    @Test
    public void updateUser_shouldInvokeValidator() {
    }

    @Test
    public void updateUser_shouldInvokeRepository() {
    }

    @Test(expected = UserAlreadyExistsValidationException.class)
    public void updateUser_shouldWrapAlreadyExistsValidationException() {
    }

    @Test(expected = UserMissingIdValidationException.class)
    public void updateUser_shouldWrapMissingIdValidationException() {
    }

    @Test
    public void deleteUser_shouldInvokeRepository() {
    }

    @Test
    public void deleteUser_ifUserDeletedShouldReturnTrue() {
    }

    @Test
    public void deleteUser_ifNoUserDeletedShouldReturnFalse() {
    }
}