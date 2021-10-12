package org;

import org.dal.impls.UserTestDAO;
import org.dal.interfaces.UserDAO;
import org.models.User;
import org.services.impls.UserServiceImpl;
import org.services.interfaces.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {
    @Bean
    public UserDAO userDAO() {
        return new UserTestDAO();
    }

    @Bean
    public List<User> users() {
        return new ArrayList<User>();
    }

    @Bean
    public UserService userService() {
        return new UserServiceImpl(userDAO());
    }
}
