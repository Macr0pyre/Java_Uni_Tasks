package org.structure.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.structure.models.Doctor;
import org.structure.models.Login;
import org.structure.models.Speciality;
import org.structure.services.interfaces.DoctorService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
public class DoctorController {
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/add-doctor")
    public ModelAndView addDoctorPage() {
        ModelAndView modelAndView = new ModelAndView("add_doctor");
        modelAndView.addObject("speciality", Arrays.asList(Speciality.values()));
        return modelAndView;
    }

    @GetMapping("/doctor/update-doctor")
    public ModelAndView updateUserPage() {
        ModelAndView modelAndView = new ModelAndView("update_doctor");
        return modelAndView;
    }

    @GetMapping("/doctor/delete-doctor")
    public ModelAndView deleteUserPage() {
        ModelAndView modelAndView = new ModelAndView("delete_doctor");
        return modelAndView;
    }

    @GetMapping("/doctor/get-doctors")
    public ModelAndView getDoctorsRequest(HttpServletResponse response) throws IOException {
        ModelAndView modelAndView = new ModelAndView("get_doctors");
        response.setContentType("text/html;charset=UTF-8");
        List<Doctor> doctors = doctorService.getAllDoctors();
        modelAndView.addObject("doctors", doctors);
        return modelAndView;
    }

    @PostMapping("/add-doctor")
    public ModelAndView addDoctorRequest(HttpServletRequest request) throws IOException {
        String name = request.getParameter("name");
        String number = request.getParameter("number");
        String email = request.getParameter("email");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String speciality = request.getParameter("speciality");
        addNewDoctor(name, number, email, login, password, speciality);

        return new ModelAndView("add_doctor");
    }

    @PostMapping("/doctor/update-doctor")
    public ModelAndView updateDoctorRequest(HttpServletRequest request) throws IOException {
        String type = request.getParameter("parameter");
        String newValue = request.getParameter("newValue");
        doctorService.updateDoctor(SecurityContextHolder.getContext().getAuthentication().getName(), type, newValue);

        return new ModelAndView("update_doctor");
    }

    @PostMapping("/doctor/delete-doctor")
    public String deleteDoctorRequest() throws IOException {
        doctorService.deleteDoctorByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        return "redirect:/logout";
    }

    private void addNewDoctor(String name, String number, String email, String login, String password, String speciality) {
        Doctor doctor = new Doctor();
        doctor.setName(name);
        doctor.setNumber(number);
        doctor.setEmail(email);
        doctor.setLogin(new Login(0, login, null, null));
        doctor.setPassword(password);
        doctor.setSpeciality(Speciality.valueOf(speciality));

        doctorService.addDoctor(doctor);
    }
}
