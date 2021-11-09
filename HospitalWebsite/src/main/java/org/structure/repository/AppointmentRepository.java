package org.structure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.structure.models.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}