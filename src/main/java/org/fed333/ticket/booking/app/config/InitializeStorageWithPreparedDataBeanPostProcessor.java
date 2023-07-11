package org.fed333.ticket.booking.app.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.fed333.ticket.booking.app.model.entity.Event;
import org.fed333.ticket.booking.app.model.entity.Ticket;
import org.fed333.ticket.booking.app.model.entity.User;
import org.fed333.ticket.booking.app.util.StorageDataUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
public class InitializeStorageWithPreparedDataBeanPostProcessor implements BeanPostProcessor {

    private static final String TARGET_BEAN_NAME = "storage";

    @Getter @Setter
    private String storageSourceJson;
    private static final String JSON_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals(TARGET_BEAN_NAME)) {
            StorageDataUtil storage = (StorageDataUtil) bean;
            log.info("Post processing of bean {} before initialization. The state {}.", beanName, bean);
            ObjectMapper mapper = new ObjectMapper();
            DateFormat df = new SimpleDateFormat(JSON_DATE_PATTERN);
            mapper.setDateFormat(df);
            try {
                JsonNode jsonNode = mapper.readTree(getClass().getResource(storageSourceJson));
                String eventsJsonString = jsonNode.get("events").toPrettyString();
                String usersJsonString = jsonNode.get("users").toPrettyString();
                String ticketsJsonString = jsonNode.get("tickets").toPrettyString();

                List<Event> events = mapper.readValue(eventsJsonString, new TypeReference<List<Event>>(){});
                List<User> users = mapper.readValue(usersJsonString, new TypeReference<List<User>>(){});
                List<Ticket> tickets = mapper.readValue(ticketsJsonString, new TypeReference<List<Ticket>>(){});

                log.info("events: {}", events);
                log.info("users: {}", users);
                log.info("tickets: {}", tickets);

                storage.getEventRepository().saveAll(events);
                storage.getAccountRepository().saveAll(users.stream().map(User::getAccount).filter(Objects::nonNull).collect(Collectors.toList()));
                storage.getUserRepository().saveAll(users);
                storage.getTicketRepository().saveAll(tickets);


                log.info("Filling of the prepared data, has been completed!");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals(TARGET_BEAN_NAME)) {
            log.info("Post processing of bean {} after initialization. The state {}.", beanName, bean);
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
