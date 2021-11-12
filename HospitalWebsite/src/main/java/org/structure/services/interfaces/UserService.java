package org.structure.services.interfaces;

import org.structure.models.User;

import java.util.List;

public interface UserService {
    User getUserByLogin(String login);

    List<User> getAllUsers();

    void addUser(User user);

    void updateUser(String login, String type, String newValue);

    void deleteUserById(long id);

    void deleteUserByLogin (String login);
}
