package ru.andreeva.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.andreeva.app.models.Doctor;

import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Optional<Doctor> findDoctorByLoginLogin(String login);

    Optional<Doctor> findDoctorByNumberIs(String number);

    Optional<Doctor> findDoctorByEmailIs(String email);
}
