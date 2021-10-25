package org.structure.dal.impls;

import org.structure.dal.interfaces.UserDAO;
import org.structure.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRealDAO implements UserDAO {
    @Override
    public User get(long id) {
        return new User();
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<>();
    }

    @Override
    public void add(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(long id) {

    }
}
