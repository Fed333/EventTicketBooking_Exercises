package org.fed333.ticket.booking.app.model.entity;

import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ticket")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Ticket implements Identifiable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(targetEntity = Event.class)
    private Event event;

    @OneToOne(targetEntity = User.class)
    private User user;

    private Category category;

    private int place;

    private boolean cancelled;

    public enum Category {STANDARD, PREMIUM, BAR}

    public Long getEventId() {
        return event.getId();
    }

    public Long getUserId() {
        return user.getId();
    }

    public void setEventId(Long id) {
        if (Objects.nonNull(event)) {
            event.setId(id);
        } else {
            event = Event.builder().id(id).build();
        }
    }

    public void setUserId(Long id) {
        if (Objects.nonNull(user)) {
            user.setId(id);
        } else {
            user = User.builder().id(id).build();
        }
    }

}
