package org.structure.services.impls;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
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

    //private final LoginRepository loginRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
//        Login login1 = loginRepository.getLoginByLogin(login).orElseThrow(() -> new UsernameNotFoundException(login));
//        User user = userRepository.findUserByLogin(login1).orElse(null);
//        if (user != null) {
//            return new org.springframework.security.core.userdetails.User(
//                    user.getName(),
//                    user.getPassword(),
//                    List.of(Role.USER)
//            );
//        }
//        else {
//            Doctor doctor = doctorRepository.findDoctorByLogin(login1).orElseThrow(() -> new UsernameNotFoundException(login));
//            return new org.springframework.security.core.userdetails.User(
//                    doctor.getName(),
//                    doctor.getPassword(),
//                    List.of(Role.DOCTOR)
//            );
//        }
        User user = userRepository.findUserByLogin(login).orElse(null);
        return new org.springframework.security.core.userdetails.User(
                    user.getLogin(),
                    user.getPassword(),
                    List.of(Role.USER)
            );
    }
}
