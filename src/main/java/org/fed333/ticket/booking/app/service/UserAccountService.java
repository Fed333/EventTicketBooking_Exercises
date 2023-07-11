package org.fed333.ticket.booking.app.service;

import lombok.RequiredArgsConstructor;
import org.fed333.ticket.booking.app.model.entity.UserAccount;
import org.fed333.ticket.booking.app.repository.UserAccountRepository;

@RequiredArgsConstructor
public class UserAccountService {

    private final UserAccountRepository userAccountRepository;

    public UserAccount refillAccount(UserAccount account, double money) {
        if (money < 0) {
            throw new RuntimeException("Money to set, cannot be negative.");
        }
        account.setMoney(money);
        return userAccountRepository.save(account);
    }

}
