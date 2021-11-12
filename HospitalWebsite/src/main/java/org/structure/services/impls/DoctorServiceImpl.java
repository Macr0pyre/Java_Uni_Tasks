package org.structure.services.impls;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.structure.models.Doctor;
import org.structure.repository.AppointmentRepository;
import org.structure.repository.DoctorRepository;
import org.structure.repository.RegistrationRepository;
import org.structure.services.interfaces.DoctorService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository doctorRepository;

    private final RegistrationRepository registrationRepository;

    private final AppointmentRepository appointmentRepository;

    private final PasswordEncoder passwordEncoder;

    @SneakyThrows
    public Doctor getDoctorByLogin(String login) {
        return doctorRepository.findDoctorByLoginLogin(login).orElseThrow(Exception::new);
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public void addDoctor(Doctor doctor) {
        doctor.setPassword(passwordEncoder.encode(doctor.getPassword()));
        doctorRepository.save(doctor);
    }

    @SneakyThrows
    public void updateDoctor(String login, String type, String newValue) {
        Doctor doctor = doctorRepository.findDoctorByLoginLogin(login).orElseThrow(Exception::new);

        if (type.equals("name")) {
            doctor.setName(newValue);
        } else if (type.equals("number")) {
            doctor.setNumber(newValue);
        } else if (type.equals("email")) {
            doctor.setEmail(newValue);
        } else if (type.equals("password")) {
            doctor.setPassword(passwordEncoder.encode(newValue));
        }

        doctorRepository.save(doctor);
    }

    public void deleteDoctorById(long id) {
        doctorRepository.deleteById(id);
    }

    @SneakyThrows
    public void deleteDoctorByLogin(String login) {
        Doctor doctor = doctorRepository.findDoctorByLoginLogin(login).orElseThrow(Exception::new);
        doctorRepository.deleteById(doctor.getId());
    }
}
