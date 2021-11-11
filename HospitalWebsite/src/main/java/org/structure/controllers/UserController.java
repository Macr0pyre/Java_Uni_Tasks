package org.structure.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.structure.models.User;
import org.structure.services.interfaces.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/add-user")
    public ModelAndView addUserPage() {
        ModelAndView modelAndView = new ModelAndView("add_user");
        return modelAndView;
    }

    @GetMapping("update-user")
    public ModelAndView updateUserPage() {
        ModelAndView modelAndView = new ModelAndView("update_user");
        return modelAndView;
    }

    @GetMapping("delete-user")
    public ModelAndView deleteUserPage() {
        ModelAndView modelAndView = new ModelAndView("delete_user");
        return modelAndView;
    }

    @GetMapping("/get-users")
    public ModelAndView getUsersRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ModelAndView modelAndView = new ModelAndView("get_users");
        response.setContentType("text/html;charset=UTF-8");
        List<User> users = userService.getAllUsers();
        modelAndView.addObject("users", users);
        return modelAndView;
    }

    @PostMapping("/add-user")
    public ModelAndView addUserRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String number = request.getParameter("number");
        String email = request.getParameter("email");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        addNewUser(name, number, email, login, password);

        return new ModelAndView("add_user");
    }

    @PostMapping("/update-user")
    public ModelAndView updateUserRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String type = request.getParameter("parameter");
        String newValue = request.getParameter("newValue");
        userService.updateUser(SecurityContextHolder.getContext().getAuthentication().getName(), type, newValue);

        return new ModelAndView("update_user");
    }

    @PostMapping("/delete-user")
    public String deleteUserRequest() throws IOException {
        userService.deleteUserByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        return "redirect:/logout";
    }

    private void addNewUser(String name, String number, String email, String login, String password) {
        User user = new User();
        user.setName(name);
        user.setNumber(number);
        user.setEmail(email);
        user.setLogin(login);
        user.setPassword(password);

        userService.addUser(user);
    }
}
