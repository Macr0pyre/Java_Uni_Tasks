package org.dal.interfaces;

import org.models.User;

import java.util.List;

public interface UserDAO {
    User get(long id);

    List<User> getAll();

    void add(User user);

    void update(User user);

    void delete(long id);
}
