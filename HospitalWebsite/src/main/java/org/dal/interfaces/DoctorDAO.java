package org.dal.interfaces;

import org.models.Doctor;

import java.util.List;

public interface DoctorDAO {
    Doctor get(long id);

    List<Doctor> getAll();

    void add(Doctor doctor);

    void update(Doctor doctor);

    void delete(long id);
}
