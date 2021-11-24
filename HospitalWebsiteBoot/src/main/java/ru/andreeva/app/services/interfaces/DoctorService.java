package ru.andreeva.app.services.interfaces;

import ru.andreeva.app.models.Appointment;
import ru.andreeva.app.models.Doctor;
import ru.andreeva.app.models.Registration;

import java.time.LocalDateTime;
import java.util.List;

public interface DoctorService {
    Doctor getDoctorByLogin(String login);

    List<Doctor> getAllDoctors();

    void addDoctor(Doctor doctor);

    void updateDoctor(Doctor doctor, String login);

    void deleteDoctorById(long id);

    void deleteDoctorByLogin (String login);

    List<Registration> getTodayRegistrations(String login);

    List<Registration> getUserRegistrations(String login, Long userId);

    void updateAppointment(Long id, Appointment appointment);

    void createRegistrations(String login, LocalDateTime dateTime);
}
