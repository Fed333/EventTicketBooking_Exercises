package org.fed333.ticket.booking.app.repository;

import org.fed333.ticket.booking.app.model.entity.Event;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findAllByTitle(String title);

    List<Event> findAllByTitle(String title, Pageable pageable);

    List<Event> findAllByDate(Date date);

    @Query(value = "SELECT * FROM event " +
            "WHERE EXTRACT(YEAR FROM date) = EXTRACT(YEAR FROM CAST(:day AS TIMESTAMP)) " +
            "AND " +
            "EXTRACT(MONTH FROM date) = EXTRACT(MONTH FROM CAST(:day AS TIMESTAMP)) " +
            "AND " +
            "EXTRACT(DAY FROM date) = EXTRACT(DAY FROM CAST(:day AS TIMESTAMP))", nativeQuery = true)
    List<Event> findAllByDay(@Param("day") Date day);

    @Query(value = "SELECT * FROM event e " +
            "WHERE EXTRACT(YEAR FROM e.date) = EXTRACT(YEAR FROM CAST(:day AS TIMESTAMP)) " +
            "AND " +
            "EXTRACT(MONTH FROM e.date) = EXTRACT(MONTH FROM CAST(:day AS TIMESTAMP)) " +
            "AND " +
            "EXTRACT(DAY FROM e.date) = EXTRACT(DAY FROM CAST(:day AS TIMESTAMP))", nativeQuery = true)
    List<Event> findAllByDay(@Param("day") Date day, Pageable pageable);

}
