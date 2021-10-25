package org.structure;

import org.structure.models.User;
import org.structure.services.interfaces.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserService service = (UserService) context.getBean("userService");

        User user = new User();
        user.setName("Пупкин Пупа Пупович");
        user.setNumber("88005553535");
        user.setEmail("pupkiiin@mail.ru");
        user.setLogin("pupkinpp");
        user.setPassword("pup123");

        service.addUser(user);

        List<User> users = service.getAllUsers();
        System.out.println(users.get(0));
    }
}
