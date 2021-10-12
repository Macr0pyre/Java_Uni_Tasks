package org.dal.interfaces;

import org.models.Appointment;

import java.util.List;

public interface AppointmentDAO {
    Appointment get(long id);

    List<Appointment> getAll();

    void add(Appointment appointment);

    void update(Appointment appointment);

    void delete(long id);
}
