package ru.andreeva.app.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import ru.andreeva.app.models.Appointment;
import ru.andreeva.app.models.Registration;
import ru.andreeva.app.models.Speciality;
import ru.andreeva.app.models.User;
import ru.andreeva.app.services.interfaces.UserService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping(value = "/user-sign-up")
    public void signUpForUser(@Valid @RequestBody User user) {
        userService.addUser(user);
    }

    @GetMapping("/user/home")
    public User getUserInfo() {
        return userService.getUserByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
    }

    @GetMapping("/user/home/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/user/home")
    public void updateUser(@Valid @RequestBody User user) {
        userService.updateUser(user, SecurityContextHolder.getContext().getAuthentication().getName());
    }

    @DeleteMapping("/user/home")
    public void deleteUser() {
        userService.deleteUserByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
    }

    @GetMapping("/user/home/registrations")
    public List<Registration> checkFreeTime(@RequestParam(required = false) String doctorName,
                                            @RequestParam(required = false) Speciality doctorType,
                                            @RequestParam Integer period) {
        return userService.checkFreeTime(doctorName, doctorType, period);
    }

    @PostMapping("/user/home/registrations/{id}")
    public void createRegistration(@PathVariable Long id) {
        userService.createRegistration(SecurityContextHolder.getContext().getAuthentication().getName(), id);
    }

    @GetMapping("/user/home/future-appointments")
    public List<Appointment> getFutureAppointments() {
        return userService.getFutureAppointments(SecurityContextHolder.getContext().getAuthentication().getName());
    }

    @GetMapping("/user/home/past-appointments")
    public List<Appointment> getPastAppointments(@RequestParam(required = false) String doctorName,
                                                    @RequestParam(required = false) String doctorType) {
        return userService.getPastAppointments(SecurityContextHolder.getContext().getAuthentication().getName(),
                doctorName,
                Speciality.valueOf(doctorType));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
