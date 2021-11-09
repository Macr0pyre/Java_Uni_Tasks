package org.structure.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.structure.services.interfaces.UserService;

@Controller
@RequiredArgsConstructor
public class HelloController {

    private final UserService userService;

    @GetMapping(value = "/sign-in")
    public String getsignInForm() {
        return "signIn";
    }

//    @GetMapping(value = "/client")
//    public String redirect() {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth.getAuthorities().contains(Role.USER)) {
//            User user = userService.findByName(auth.getName());
//            return "redirect:/user/" + user.getId();
//        } else {
//            Doctor doctor = doctorService.findByName(auth.getName());
//            return "redirect:/doctor/" + doctor.getId();
//        }
//    }
}
