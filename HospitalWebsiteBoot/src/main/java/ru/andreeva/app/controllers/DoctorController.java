package ru.andreeva.app.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import ru.andreeva.app.exception.BadRequestException;
import ru.andreeva.app.models.Appointment;
import ru.andreeva.app.models.Doctor;
import ru.andreeva.app.models.Registration;
import ru.andreeva.app.services.interfaces.DoctorService;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class DoctorController {
    private final DoctorService doctorService;

    @PostMapping(value = "/doctor-sign-up")
    public void signUpForDoctor(@Valid @RequestBody Doctor Doctor) {
        doctorService.addDoctor(Doctor);
    }

    @GetMapping("/doctor/home")
    public Doctor getDoctorInfo() {
        return doctorService.getDoctorByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
    }

    @GetMapping("/doctor/home/all")
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @PutMapping("/doctor/home")
    public void updateDoctor(@Valid @RequestBody Doctor Doctor) {
        doctorService.updateDoctor(Doctor, SecurityContextHolder.getContext().getAuthentication().getName());
    }

    @DeleteMapping("doctor/home")
    public void deleteDoctor() {
        doctorService.deleteDoctorByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
    }

    @GetMapping("doctor/home/today-registrations")
    public List<Registration> getTodayRegistrations() {
        return doctorService.getTodayRegistrations(SecurityContextHolder.getContext().getAuthentication().getName());
    }

    @GetMapping("doctor/home/appointments-of-user/{id}")
    public List<Registration> getUserRegistrations(@PathVariable("id") Long userId) {
        return doctorService.getUserRegistrations(SecurityContextHolder.getContext().getAuthentication().getName(), userId);
    }

    @PutMapping("doctor/home/update-appointment/{id}")
    public void updateAppointment(@PathVariable Long id, @RequestBody Appointment appointment) {
        doctorService.updateAppointment(id, appointment);
    }

    @PostMapping("doctor/home/create-registration")
    public void createRegistrations(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @RequestParam("date-time") LocalDateTime dateTime) {
        if (LocalDateTime.now().isAfter(dateTime)) {
            throw new BadRequestException("Дата и время не могут предшествовать сегодняшней");
        } else {
            doctorService.createRegistrations(SecurityContextHolder.getContext().getAuthentication().getName(), dateTime);
        }
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