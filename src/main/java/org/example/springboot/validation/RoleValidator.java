package org.example.springboot.validation;

import lombok.RequiredArgsConstructor;
import org.example.springboot.dto.RoleDTO;
import org.example.springboot.service.RoleService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@Component
@RequiredArgsConstructor
public class RoleValidator implements Validator {

    private final RoleService roleService;


    @Override
    public boolean supports(Class<?> clazz) {
        return RoleDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
     RoleDTO targetRole = (RoleDTO) target;

     boolean exists = roleService.findAll().stream()
             .anyMatch(role->targetRole.getRole().equals(role.getRoleType().name()));
     if (exists){
        errors.rejectValue("role", "");
      }
    }
}
