package org.example.springboot.validation;

import lombok.RequiredArgsConstructor;
import org.example.springboot.dto.PlaceAdsDTO;
import org.example.springboot.entity.PlaceAds;
import org.example.springboot.service.PlaceAdsService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PlaceAdsValidator implements Validator {
    private final PlaceAdsService placeAdsService;
    @Override
    public boolean supports(Class<?> clazz) {
        return PlaceAdsDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
     PlaceAdsDTO placeAdsDTO = (PlaceAdsDTO) target;
        Optional<PlaceAds> placeAds = placeAdsService.getPlaceAdsByName(placeAdsDTO.getName());
        if (placeAds.isPresent()){
            errors.rejectValue("name","","Такой обьявления существует!");
        }
    }

}
