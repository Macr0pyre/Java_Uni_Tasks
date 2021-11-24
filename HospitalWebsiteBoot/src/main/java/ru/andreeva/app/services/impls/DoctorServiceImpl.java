package ru.andreeva.app.services.impls;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.andreeva.app.exception.NotFoundException;
import ru.andreeva.app.exception.UniqueException;
import ru.andreeva.app.models.Appointment;
import ru.andreeva.app.models.Doctor;
import ru.andreeva.app.models.Login;
import ru.andreeva.app.models.Registration;
import ru.andreeva.app.repository.AppointmentRepository;
import ru.andreeva.app.repository.DoctorRepository;
import ru.andreeva.app.repository.LoginRepository;
import ru.andreeva.app.repository.RegistrationRepository;
import ru.andreeva.app.services.interfaces.DoctorService;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository doctorRepository;

    private final RegistrationRepository registrationRepository;

    private final AppointmentRepository appointmentRepository;

    private final LoginRepository loginRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public Doctor getDoctorByLogin(String login) {
        return doctorRepository.findDoctorByLoginLogin(login).orElseThrow(() -> new NotFoundException("Пользователь не найден"));
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public void addDoctor(Doctor doctor) {
        if (loginRepository.getLoginByLogin(doctor.getLogin().getLogin()).isPresent()) {
            throw new UniqueException("Введенный логин занят придумайте другой");
        } else if (doctorRepository.findDoctorByNumberIs(doctor.getNumber()).isPresent()) {
            throw new UniqueException("Данный номер телефона уже используется");
        } else if (doctorRepository.findDoctorByEmailIs(doctor.getEmail()).isPresent()) {
            throw new UniqueException("Данный емэйл уже используется");
        } else {
            Login login = new Login(null, doctor.getLogin().getLogin());
            doctor.setPassword(passwordEncoder.encode(doctor.getPassword()));
            doctor.setLogin(login);
            doctorRepository.save(doctor);
        }
    }

    @Override
    public void updateDoctor(Doctor doctorInput, String login) {
        doctorInput.setPassword(passwordEncoder.encode(doctorInput.getPassword()));
        Doctor doctor = doctorRepository.findDoctorByLoginLogin(login).orElseThrow(() -> new NotFoundException("Пользователь не найден"));

        if (!doctor.getLogin().getLogin().equals(doctorInput.getLogin().getLogin()) &&
                loginRepository.getLoginByLogin(doctorInput.getLogin().getLogin()).isPresent()) {
            throw new UniqueException("Введенный логин занят придумайте другой");
        } else if (!doctor.getNumber().equals(doctorInput.getNumber()) &&
                doctorRepository.findDoctorByNumberIs(doctorInput.getNumber()).isPresent()) {
            throw new UniqueException("Данный номер телефона уже используется");
        } else  if (!doctor.getEmail().equals(doctorInput.getEmail()) &&
                doctorRepository.findDoctorByEmailIs(doctorInput.getEmail()).isPresent()) {
            throw new UniqueException("Данный емэйл уже используется");
        } else {
            if (!doctor.getLogin().getLogin().equals(doctorInput.getLogin().getLogin())) {
                doctor.setLogin(new Login(null, doctorInput.getLogin().getLogin()));
            }
            doctor.setName(doctorInput.getName());
            doctor.setPassword(doctorInput.getPassword());
            doctor.setNumber(doctorInput.getNumber());
            doctor.setEmail(doctorInput.getEmail());
            doctor.setSpeciality(doctorInput.getSpeciality());
            doctorRepository.save(doctor);
        }
    }

    @Override
    public void deleteDoctorById(long id) {
        doctorRepository.deleteById(id);
    }

    public void deleteDoctorByLogin(String login) {
        Doctor doctor = doctorRepository.findDoctorByLoginLogin(login).orElseThrow(() -> new NotFoundException("Пользователь не найден"));
        doctorRepository.deleteById(doctor.getId());
    }

    @Override
    public void createRegistrations(String login, LocalDateTime dateTime) {
        Doctor doctor = doctorRepository.findDoctorByLoginLogin(login).orElseThrow(() -> new NotFoundException("Пользователь не найден"));
        Registration registration = registrationRepository.save(new Registration(null, null, doctor, dateTime, null));
        appointmentRepository.save(new Appointment(null, registration, "", null, false));
    }

    @Override
    public void updateAppointment(Long id, Appointment appointmentInput) {
        Appointment appointment = appointmentRepository.findById(id).orElseThrow(() -> new NotFoundException("Запись не найдена"));
        appointment.setDescription(appointmentInput.getDescription());
        appointment.setStatus(appointmentInput.getStatus());
        appointment.setIsVisited(appointmentInput.getIsVisited());
        appointmentRepository.save(appointment);
    }

    @Override
    public List<Registration> getTodayRegistrations(String login) {
        return registrationRepository.findRegistrationByDoctorLoginLoginAndTimeOfAppointmentBetween(login, LocalDateTime.now(), LocalDateTime.now().plusDays(1));
    }

    @Override
    public List<Registration> getUserRegistrations(String login, Long userId) {
        Doctor doctor = doctorRepository.findDoctorByLoginLogin(login).orElseThrow(() -> new NotFoundException("Пользователь не найден"));
        return registrationRepository.findRegistrationByDoctorIdAndUserId(doctor.getId(), userId);
    }

}
