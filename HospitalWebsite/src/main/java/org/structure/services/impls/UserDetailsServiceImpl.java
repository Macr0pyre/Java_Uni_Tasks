package org.structure.services.impls;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.structure.models.Doctor;
import org.structure.models.Role;
import org.structure.repository.UserRepository;
import org.structure.models.User;
import org.structure.repository.DoctorRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    private final DoctorRepository doctorRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.findUserByLoginLogin(login).orElse(null);
        if (user != null) {
            return new org.springframework.security.core.userdetails.User(
                    user.getLogin().getLogin(),
                    user.getPassword(),
                    List.of(Role.USER)
            );
        }
        else {
            Doctor doctor = doctorRepository.findDoctorByLoginLogin(login).orElseThrow(() -> new UsernameNotFoundException(login));
            return new org.springframework.security.core.userdetails.User(
                    doctor.getLogin().getLogin(),
                    doctor.getPassword(),
                    List.of(Role.DOCTOR)
            );
        }
    }
}
