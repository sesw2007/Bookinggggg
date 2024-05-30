package org.example.springboot.controller;

import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.example.springboot.dto.PlaceAdsDTO;
import org.example.springboot.service.PlaceAdsService;
import org.example.springboot.validation.PlaceAdsValidator;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/placeads")
public class PlaceAdsController {
    private final PlaceAdsService placeAdsService;
    private final PlaceAdsValidator validator;

    @GetMapping("/add-default")
    public void createDefaultPlaceAds(){
        placeAdsService.addDefault();
    }
    @GetMapping("get-all")
    public List<PlaceAdsDTO> getAllPlaceAdsDTO(){
     return  placeAdsService.getAllPlaceAdsDTO();
    }

    @PostMapping("/add-placeads")
    public PlaceAdsDTO addNewPlaceAds(@RequestBody PlaceAdsDTO placeAdsDTO, BindingResult bindingResult){
        validator.validate(placeAdsDTO, bindingResult);
        if (bindingResult.hasErrors()){
            throw new ValidationException();
        }
        return placeAdsService.addNewPlaceAds(placeAdsDTO);
    }
    @DeleteMapping("delete-placeads")
    public void deletePlaceAds(UUID id){
        placeAdsService.deletePlaceAds(id);
    }

    @GetMapping("/activita-placeads")
    public boolean activitaPlaceAds(){
      return placeAdsService.activityPlaceAds();
    }

    @PutMapping("/edit")
    public PlaceAdsDTO edit(@RequestBody PlaceAdsDTO placeAdsDTO){
        return placeAdsService.editApplicationRent(placeAdsDTO);
    }
}
