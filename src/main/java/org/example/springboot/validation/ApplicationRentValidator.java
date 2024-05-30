package org.example.springboot.validation;

import lombok.RequiredArgsConstructor;
import org.example.springboot.dto.ApplicationRentDTO;
import org.example.springboot.entity.ApplicationRent;

import org.example.springboot.service.ApplicationRentService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;
@Component
@RequiredArgsConstructor
public class ApplicationRentValidator implements Validator {
    private final ApplicationRentService applicationRentService;
    @Override
    public boolean supports(Class<?> clazz) {
        return ApplicationRentDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
     ApplicationRentDTO applicationRentDTO = (ApplicationRentDTO) target;
        Optional<ApplicationRent> applicationRent = applicationRentService.getApplicationRentByName(applicationRentDTO.getName());
        if (applicationRent.isPresent()){
            errors.rejectValue("name", "", "Такая аренда существует!");
        }
    }
}
