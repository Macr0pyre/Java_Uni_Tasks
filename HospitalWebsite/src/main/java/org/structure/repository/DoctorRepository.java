package org.structure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.structure.models.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
