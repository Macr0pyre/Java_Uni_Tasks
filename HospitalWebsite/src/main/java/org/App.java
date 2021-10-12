package org;

import org.models.User;
import org.services.interfaces.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        UserService service = (UserService) context.getBean("userService");
        User user = new User();
        user.setName("Иванов Иван Иванович");
        user.setNumber("88005553535");
        user.setEmail("ivanov350@gmail.com");
        user.setLogin("ivanov_ii");
        user.setPassword("1234");
        service.addUser(user);

        List<User> users = service.getAllUsers();
        System.out.println(users.get(0));
    }
}
