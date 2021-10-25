package org.structure.services.impls;

import org.structure.dal.interfaces.UserDAO;
import org.structure.models.User;
import org.structure.services.interfaces.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDAO userDao;

    public UserServiceImpl(UserDAO userDao) {
        this.userDao = userDao;
    }

    public User getUser(long id) {
        return userDao.get(id);
    }

    public List<User> getAllUsers() {
        return userDao.getAll();
    }

    public void addUser(User user) {
        userDao.add(user);
    }

    public void updateUser(long id, String type, String newValue) {
        User user = userDao.get(id);

        if (type.equals("name")) {
            user.setName(newValue);
        } else if (type.equals("number")) {
            user.setNumber(newValue);
        } else if (type.equals("email")) {
            user.setEmail(newValue);
        } else if (type.equals("login")) {
            user.setLogin(newValue);
        } else if (type.equals("password")) {
            user.setPassword(newValue);
        }

        userDao.update(user);
    }

    public void deleteUser(long id) {
        userDao.delete(id);
    }
}
