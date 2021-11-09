package org.structure.services.impls;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.structure.models.User;
import org.structure.repository.AppointmentRepository;
import org.structure.repository.RegistrationRepository;
import org.structure.repository.UserRepository;
import org.structure.services.interfaces.UserService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RegistrationRepository registrationRepository;

    private final AppointmentRepository appointmentRepository;

    @SneakyThrows
    public User getUser(long id) {
        return userRepository.findById(id).orElseThrow(Exception::new);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(long id, String type, String newValue) {
        User user = getUser(id);

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

        userRepository.save(user);
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }
}
