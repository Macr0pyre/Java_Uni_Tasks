package ru.andreeva.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.andreeva.app.models.Registration;
import ru.andreeva.app.models.Speciality;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    List<Registration> findRegistrationByDoctorIdAndUserId(Long doctorId, Long userId);

    List<Registration> findRegistrationByDoctorLoginLoginAndTimeOfAppointmentBetween(String login, LocalDateTime firstDate, LocalDateTime secondDate);

    List<Registration> findRegistrationByUserIsNullAndTimeOfAppointmentBefore(LocalDateTime localDateTime);

    List<Registration> findRegistrationByDoctorNameAndUserIsNullAndTimeOfAppointmentBefore(String name, LocalDateTime localDateTime);

    List<Registration> findRegistrationByDoctorSpecialityAndUserIsNullAndTimeOfAppointmentBefore(Speciality speciality, LocalDateTime localDateTime);
}