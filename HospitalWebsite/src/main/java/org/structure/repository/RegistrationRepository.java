package org.structure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.structure.models.Registration;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {
}
