package org.structure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.structure.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
