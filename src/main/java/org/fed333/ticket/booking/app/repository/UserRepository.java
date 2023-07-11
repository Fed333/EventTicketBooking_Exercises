package org.fed333.ticket.booking.app.repository;

import org.fed333.ticket.booking.app.model.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByName(String name);

    List<User> findAllByName(String name, Pageable pageable);

    List<User> findAllByEmail(String email);

}
