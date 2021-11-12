package org.structure.services.interfaces;

import org.structure.models.Doctor;

import java.util.List;

public interface DoctorService {
    Doctor getDoctorByLogin(String login);

    List<Doctor> getAllDoctors();

    void addDoctor(Doctor doctor);

    void updateDoctor(String login, String type, String newValue);

    void deleteDoctorById(long id);

    void deleteDoctorByLogin (String login);
}
