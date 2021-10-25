package org.structure.dal.interfaces;

import org.structure.models.User;

import java.util.List;

public interface UserDAO {
    User get(long id);

    List<User> getAll();

    void add(User user);

    void update(User user);

    void delete(long id);
}
