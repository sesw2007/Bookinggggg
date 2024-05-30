package org.example.springboot.validation;

import lombok.RequiredArgsConstructor;
import org.example.springboot.dto.HousingDTO;
import org.example.springboot.entity.Housing;
import org.example.springboot.service.HousingService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class HousingValidator implements Validator {
    private final HousingService housingService;

    @Override
    public boolean supports(Class<?> clazz) {
        return HousingDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
       HousingDTO housingDTO = (HousingDTO) target;
        Optional<Housing> housing = housingService.getHousingByName(housingDTO.getName());
        if (housing.isPresent()){
            errors.rejectValue("name","","Такой жильё существует!");
        }
    }
}
