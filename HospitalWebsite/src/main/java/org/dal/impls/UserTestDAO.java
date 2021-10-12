package org.dal.impls;

import org.dal.interfaces.UserDAO;
import org.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserTestDAO implements UserDAO {

    @Autowired
    private List<User> testUsers;

    @Override
    public User get(long id) {
        Optional<User> user = testUsers.stream()
                .filter(x -> x.getId() == id)
                .findFirst();

        return user.orElse(new User());
    }

    @Override
    public List<User> getAll() {
        return testUsers;
    }

    @Override
    public void add(User user) {
        testUsers.add(user);
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(long id) {
        Optional<User> user = Optional.ofNullable(get(id));
        if (user.isPresent()) {
            testUsers.remove(user);
        }
    }
}
