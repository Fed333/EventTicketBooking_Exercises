package org.fed333.ticket.booking.app.repository;

import org.fed333.ticket.booking.app.model.entity.Identifiable;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Transactional
public interface CrudRepository<E extends Identifiable<ID>, ID> {

    boolean existsById(ID id);

    E getById(ID id);

    List<E> getAll();

    E save(E e);

    Collection<E> save(Collection<E> entities);

    E remove(E e);

    E remove(ID id);

}
