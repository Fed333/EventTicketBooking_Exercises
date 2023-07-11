package org.fed333.ticket.booking.app.service;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.fed333.ticket.booking.app.exception.AlreadyExistsValidationException;
import org.fed333.ticket.booking.app.exception.MissingIdValidationException;
import org.fed333.ticket.booking.app.exception.user.UserAlreadyExistsValidationException;
import org.fed333.ticket.booking.app.exception.user.UserMissingIdValidationException;
import org.fed333.ticket.booking.app.model.entity.User;
import org.fed333.ticket.booking.app.model.entity.UserAccount;
import org.fed333.ticket.booking.app.repository.UserAccountRepository;
import org.fed333.ticket.booking.app.repository.UserRepository;
import org.fed333.ticket.booking.app.service.component.SaveEntityValidator;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final UserAccountRepository accountRepository;

    @Setter
    private SaveEntityValidator<User, Long> saveUserValidator;

    private void init(){
        saveUserValidator.setRepository(userRepository);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User getUserByEmail(String email) {
        List<User> users = userRepository.findAllByEmail(email);
        if (users.isEmpty()){
            log.info("No user with email {} was found.", email);
            return null;
        }
        if (users.size() > 1) {
            throw new RuntimeException("More than one users was found!");
        }
        return users.get(0);
    }

    public List<User> getUsersByName(String name, Pageable page) {
        return userRepository.findAllByName(name, page);
    }

    public User createUser(User user) {
        try {
            saveUserValidator.validateCreate(user);
        } catch (AlreadyExistsValidationException e) {
            throw new UserAlreadyExistsValidationException(e);
        }

        UserAccount account = user.getAccount();
        if (Objects.nonNull(account)) {
            UserAccount savedAccount = accountRepository.save(account);
            user.setAccount(savedAccount);
        }
        User saved = userRepository.save(user);

        log.info("User {} has been created successfully.", saved);
        return saved;
    }

    public User updateUser(User user) {
        try {
            saveUserValidator.validateUpdate(user);
        } catch (MissingIdValidationException e) {
            throw new UserMissingIdValidationException(e);
        } catch (AlreadyExistsValidationException e) {
            throw new UserAlreadyExistsValidationException(e);
        }

        User saved = userRepository.save(user);
        log.info("User {} has been updated successfully.", saved);
        return saved;
    }

    public boolean deleteUser(long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            userRepository.deleteById(userId);
            User removed = optionalUser.get();
            log.info("User {} was deleted successfully.", removed);
            return true;
        }
        return false;
    }

}