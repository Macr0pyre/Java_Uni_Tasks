package org.structure.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.structure.models.Role;

@Controller
@RequiredArgsConstructor
public class SupportingController {

    @GetMapping(value = "/sign-in")
    public String getsignInForm() {
        return "signIn";
    }

    @GetMapping(value = "/client")
    public String redirect() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getAuthorities().contains(Role.USER)) {
            return "redirect:/user/get-users";
        } else {
            return "redirect:/doctor/get-doctors";
        }
    }
}