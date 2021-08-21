package com.pwc.complaintmanagementportal.uses;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsersService implements UserDetailsService {

    private final static String userNotFoundMsg = "user with %s email was not found";
    private final UsersRepository usersRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return usersRepository.findByEmail(email)
                .orElseThrow(() ->
                    new UsernameNotFoundException(String.format(userNotFoundMsg,email)));
    }

    public String signUpUser(Users user) {

        Boolean emailExists = usersRepository.findByEmail(user.getEmail())
                                            .isPresent();

        if ( emailExists ) {
            return "emailAlreadyUsed";
        }

        // this is to encode the password.
        String encodedPass = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPass);

        usersRepository.save(user);

        return "User Created";
    }

}
