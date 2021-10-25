package org.structure.dal.impls;

import org.structure.dal.interfaces.UserDAO;
import org.structure.models.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserTestDAO implements UserDAO {

    private List<User> testUsers;

    public UserTestDAO(List<User> testUsers) {
        this.testUsers = testUsers;
    }

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
        User user = get(id);
        if(user.getName() != null) {
            testUsers.remove(user);
        }
    }

    public void setTestUsers(List<User> testUsers) {
        this.testUsers = testUsers;
    }
}
