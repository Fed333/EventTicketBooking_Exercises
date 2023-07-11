package org.fed333.ticket.booking.app.util;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.fed333.ticket.booking.app.repository.EventRepository;
import org.fed333.ticket.booking.app.repository.TicketRepository;
import org.fed333.ticket.booking.app.repository.UserAccountRepository;
import org.fed333.ticket.booking.app.repository.UserRepository;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * The bean, to initialize implementations of repository classes
 * on the startup of {@link ApplicationContext}
 * using {@link BeanPostProcessor} features.<br>
 * @author Roman_Kovalchuk
 * */
@Slf4j
@ToString
@Getter @Setter
@Transactional
public class StorageDataUtil {

    private EventRepository eventRepository;

    private UserRepository userRepository;

    private TicketRepository ticketRepository;

    private UserAccountRepository accountRepository;

    private void init() {
        log.info("StorageDataUtil init() method invoked!");

        log.info("Total events: {}", eventRepository.findAll());
        log.info("Total users: {}", userRepository.findAll());
        log.info("Total repositories: {}", ticketRepository.findAll());
    }

}
