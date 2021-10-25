package org.structure;

import org.structure.dal.impls.UserRealDAO;
import org.structure.dal.impls.UserTestDAO;
import org.structure.dal.interfaces.UserDAO;
import org.structure.models.User;
import org.structure.services.impls.UserServiceImpl;
import org.structure.services.interfaces.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {
    @Bean
    public List<User> users() {
        return new ArrayList<User>();
    }

    @Bean
    public UserDAO userTestDAO() {
        return new UserTestDAO(users());
    }

    @Bean
    public UserDAO userRealDAO() {
        return new UserRealDAO();
    }

    @Bean
    public UserService userService() {
        return new UserServiceImpl(userTestDAO());
    }
}
