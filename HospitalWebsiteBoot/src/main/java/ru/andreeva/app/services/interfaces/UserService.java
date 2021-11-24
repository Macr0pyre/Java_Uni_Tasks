package ru.andreeva.app.services.interfaces;

import ru.andreeva.app.models.Appointment;
import ru.andreeva.app.models.Registration;
import ru.andreeva.app.models.Speciality;
import ru.andreeva.app.models.User;

import java.util.List;

public interface UserService {
    User getUserByLogin(String login);

    List<User> getAllUsers();

    void addUser(User user);

    void updateUser(User user, String login);

    void deleteUserById(long id);

    void deleteUserByLogin (String login);

    List<Registration> checkFreeTime(String doctorName, Speciality doctorType, Integer period);

    void createRegistration(String login, Long registrationId);

    List<Appointment> getFutureAppointments(String login);

    List<Appointment> getPastAppointments(String login, String doctorName, Speciality doctorType);

}
