package org.services.interfaces;

import org.models.User;

import java.util.List;

public interface UserService {
    User getUser(long id);

    List<User> getAllUsers();

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(long id);
}
