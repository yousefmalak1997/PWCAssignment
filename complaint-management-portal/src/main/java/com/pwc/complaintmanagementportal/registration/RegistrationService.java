package com.pwc.complaintmanagementportal.registration;

import com.pwc.complaintmanagementportal.uses.Users;
import com.pwc.complaintmanagementportal.uses.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final UsersService usersService;
    private final EmailValidator emailValidator;


    public String register(RegistrationRequest request) {

        boolean isValidEmail = emailValidator.test(request.getEmail());
        System.out.println(request);
        if ( !isValidEmail ) {
            return "notValidEmail";
        }

        if( request.getFirstName().isEmpty() ||
            request.getLastName().isEmpty() ||
            request.getEmail().isEmpty() ||
            request.getPassword().isEmpty() ||
            request.getUserRole() == null ) {
            return "EnterAllOptions";
        }

        String token = usersService.signUpUser(
                new Users(
                        request.getFirstName(),
                        request.getLastName(),
                        request.getEmail(),
                        request.getPassword(),
                        request.getUserRole()
                )
        );

        return token;
    }

}
