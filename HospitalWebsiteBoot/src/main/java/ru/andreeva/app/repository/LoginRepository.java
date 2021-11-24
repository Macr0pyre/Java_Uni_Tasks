package ru.andreeva.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.andreeva.app.models.Login;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {
    Optional<Login> getLoginByLogin(String login);
}