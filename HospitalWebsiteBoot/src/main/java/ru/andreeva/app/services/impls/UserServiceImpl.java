package ru.andreeva.app.services.impls;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.andreeva.app.exception.NotFoundException;
import ru.andreeva.app.exception.UniqueException;
import ru.andreeva.app.models.*;
import ru.andreeva.app.repository.AppointmentRepository;
import ru.andreeva.app.repository.LoginRepository;
import ru.andreeva.app.repository.RegistrationRepository;
import ru.andreeva.app.repository.UserRepository;
import ru.andreeva.app.services.interfaces.UserService;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final LoginRepository loginRepository;

    private final RegistrationRepository registrationRepository;

    private final AppointmentRepository appointmentRepository;

    private final PasswordEncoder passwordEncoder;

    public User getUserByLogin(String login) {
        return userRepository.findUserByLoginLogin(login).orElseThrow(() -> new NotFoundException("Пользователь не найден"));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void addUser(User user) {
        if (loginRepository.getLoginByLogin(user.getLogin().getLogin()).isPresent()) {
            throw new UniqueException("Введенный логин занят придумайте другой");
        } else if (userRepository.findUserByNumberIs(user.getNumber()).isPresent()) {
            throw new UniqueException("Данный номер телефона уже используется");
        } else  if (userRepository.findUserByEmailIs(user.getEmail()).isPresent()) {
            throw new UniqueException("Данный емэйл уже используется");
        } else {
            Login login = new Login(null, user.getLogin().getLogin());
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setLogin(login);
            userRepository.save(user);
        }
    }

    @Override
    public void updateUser(User userInput, String login) {
        userInput.setPassword(passwordEncoder.encode(userInput.getPassword()));
        User user = userRepository.findUserByLoginLogin(login).orElseThrow(() -> new NotFoundException("Пользователь не найден"));

        if (!user.getLogin().getLogin().equals(userInput.getLogin().getLogin()) &&
                loginRepository.getLoginByLogin(userInput.getLogin().getLogin()).isPresent()) {
            throw new UniqueException("Введенный логин занят придумайте другой");
        } else if (!user.getNumber().equals(userInput.getNumber()) &&
                userRepository.findUserByNumberIs(userInput.getNumber()).isPresent()) {
            throw new UniqueException("Данный номер телефона уже используется");
        } else  if (!user.getEmail().equals(userInput.getEmail()) &&
                userRepository.findUserByEmailIs(userInput.getEmail()).isPresent()) {
            throw new UniqueException("Данный емэйл уже используется");
        } else {
            if (!user.getLogin().getLogin().equals(userInput.getLogin().getLogin())) {
                user.setLogin(new Login(null, userInput.getLogin().getLogin()));
            }
            user.setName(userInput.getName());
            user.setPassword(userInput.getPassword());
            user.setNumber(userInput.getNumber());
            user.setEmail(userInput.getEmail());
            userRepository.save(user);
        }
    }

    @Override
    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void deleteUserByLogin(String login) {
        User user = userRepository.findUserByLoginLogin(login).orElseThrow(() -> new NotFoundException("Пользователь не найден"));
        userRepository.deleteById(user.getId());
    }

    @Override
    public List<Registration> checkFreeTime(String doctorName, Speciality doctorType, Integer period) {
        List<Registration> registrationList;
        if (doctorName != null) {
            registrationList = registrationRepository.findRegistrationByDoctorNameAndUserIsNullAndTimeOfAppointmentBefore(doctorName, LocalDateTime.now().plusDays(period));
        } else if (doctorType != null) {
            registrationList = registrationRepository.findRegistrationByDoctorSpecialityAndUserIsNullAndTimeOfAppointmentBefore(doctorType, LocalDateTime.now().plusDays(period));
        } else {
            registrationList = registrationRepository.findRegistrationByUserIsNullAndTimeOfAppointmentBefore(LocalDateTime.now().plusDays(period));
        }
        return registrationList;
    }

    @Override
    public void createRegistration(String login, Long registrationId) {
        Registration registration = registrationRepository.findById(registrationId).orElseThrow(() -> new NotFoundException("Запись не найдена"));
        registration.setUser(userRepository.findUserByLoginLogin(login).orElseThrow(() -> new NotFoundException("Пользователь не найден")));
        registrationRepository.save(registration);
    }

    @Override
    public List<Appointment> getFutureAppointments(String login) {
        return appointmentRepository.findAppointmentByRegistrationUserLoginLoginAndIsVisitedFalse(login);
    }

    @Override
    public List<Appointment> getPastAppointments(String login, String doctorName, Speciality doctorType) {
        List<Appointment> appointmentList;
        if (doctorName != null) {
            appointmentList = appointmentRepository.findAppointmentByRegistrationUserLoginLoginAndRegistrationDoctorNameAndIsVisitedTrue(login, doctorName);
        } else if (doctorType != null){
            appointmentList = appointmentRepository.findAppointmentByRegistrationUserLoginLoginAndRegistrationDoctorSpecialityAndIsVisitedTrue(login,
                    doctorType);
        } else {
            appointmentList = appointmentRepository.findAppointmentByRegistrationUserLoginLoginAndIsVisitedTrue(login);
        }
        return appointmentList;
    }
}
