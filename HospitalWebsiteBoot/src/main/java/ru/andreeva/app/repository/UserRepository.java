package ru.andreeva.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.andreeva.app.models.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByLoginLogin(String login);

    Optional<User> findUserByNumberIs(String number);

    Optional<User> findUserByEmailIs(String email);
}
