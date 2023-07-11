package org.fed333.ticket.booking.app.model.entity;

public interface Identifiable<ID> {

    void setId(ID id);

    ID getId();

}
