package org.structure.services.impls;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.structure.models.User;
import org.structure.repository.AppointmentRepository;
import org.structure.repository.RegistrationRepository;
import org.structure.repository.UserRepository;
import org.structure.services.interfaces.UserService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RegistrationRepository registrationRepository;

    private final AppointmentRepository appointmentRepository;

    private final PasswordEncoder passwordEncoder;

    @SneakyThrows
    public User getUser(long id) {
        return userRepository.findById(id).orElseThrow(Exception::new);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @SneakyThrows
    public void updateUser(String login, String type, String newValue) {
        User user = userRepository.findUserByLogin(login).orElseThrow(Exception::new);

        if (type.equals("name")) {
            user.setName(newValue);
        } else if (type.equals("number")) {
            user.setNumber(newValue);
        } else if (type.equals("email")) {
            user.setEmail(newValue);
        } else if (type.equals("password")) {
            user.setPassword(passwordEncoder.encode(newValue));
        }

        userRepository.save(user);
    }

    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }

    public void deleteUserByLogin(String login) {
        userRepository.deleteUserByLogin(login);
    }
}
