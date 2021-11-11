package org.structure.services.interfaces;

import org.structure.models.User;

import java.util.List;

public interface UserService {
    User getUser(long id);

    List<User> getAllUsers();

    void addUser(User user);

    void updateUser(String login, String type, String newValue);

    void deleteUserById(long id);

    void deleteUserByLogin (String login);
}
