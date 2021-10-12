package org.services.impls;

import org.dal.interfaces.UserDAO;
import org.models.User;
import org.services.interfaces.UserService;

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

    public void updateUser(User user) {
        userDao.update(user);
    }

    public void deleteUser(long id) {
        userDao.delete(id);
    }
}
