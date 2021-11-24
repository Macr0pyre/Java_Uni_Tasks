package ru.andreeva.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.andreeva.app.models.Appointment;
import ru.andreeva.app.models.Speciality;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findAppointmentByRegistrationUserLoginLoginAndIsVisitedFalse(String login);

    List<Appointment> findAppointmentByRegistrationUserLoginLoginAndIsVisitedTrue(String login);

    List<Appointment> findAppointmentByRegistrationUserLoginLoginAndRegistrationDoctorNameAndIsVisitedTrue(String login, String doctorName);

    List<Appointment> findAppointmentByRegistrationUserLoginLoginAndRegistrationDoctorSpecialityAndIsVisitedTrue(String login, Speciality doctorSpeciality);
}