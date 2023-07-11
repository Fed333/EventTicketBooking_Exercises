package org.fed333.ticket.booking.app.repository;

import org.fed333.ticket.booking.app.model.entity.Ticket;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Query(value = "SELECT * FROM ticket t WHERE t.event_id = :eventId", nativeQuery = true)
    List<Ticket> findAllByEventId(@Param("eventId") Long eventId);

    @Query(value = "SELECT * FROM ticket t WHERE t.event_id = :eventId", nativeQuery = true)
    List<Ticket> findAllByEventId(@Param("eventId") Long eventId, Pageable pageable);

    @Query(value = "SELECT * FROM ticket t WHERE t.user_id = :userId", nativeQuery = true)
    List<Ticket> findAllByUserId(@Param("userId") Long userId);

    @Query(value = "SELECT * FROM ticket t WHERE t.user_id = :userId", nativeQuery = true)
    List<Ticket> findAllByUserId(@Param("userId") Long userId, Pageable pageable);

    @Query(value = "SELECT * FROM ticket t WHERE t.user_id = :userId AND t.event_id = :eventId", nativeQuery = true)
    Ticket findByUserIdAndEventId(@Param("userId") Long userId, @Param("eventId") Long eventId);
}
