package org.example.springboot.validation;

import lombok.RequiredArgsConstructor;
import org.example.springboot.dto.UserDTO;
import org.example.springboot.entity.User;
import org.example.springboot.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserValidator implements Validator {
    private final UserService userService;
    @Override
    public boolean supports(Class<?>clazz){

        return UserDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDTO userDTO = (UserDTO) target;
//        Optional<User> user = userService.getUserByName(userDTO.getUsername());

//        if (user.isPresent()){
//            errors.rejectValue("name","","Такой пользователь существует!");
//        }
    }

}
