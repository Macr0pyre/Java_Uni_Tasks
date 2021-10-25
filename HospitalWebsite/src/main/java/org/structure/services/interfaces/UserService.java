package org.structure.services.interfaces;

import org.structure.models.User;

import java.util.List;

public interface UserService {
    User getUser(long id);

    List<User> getAllUsers();

    void addUser(User user);

    void updateUser(long id, String type, String newValue);

    void deleteUser(long id);
}
