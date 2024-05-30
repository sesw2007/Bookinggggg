package org.example.springboot.controller;

import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.example.springboot.dto.HousingDTO;
import org.example.springboot.entity.Housing;
import org.example.springboot.enums.City;
import org.example.springboot.enums.Country;
import org.example.springboot.service.HousingService;
import org.example.springboot.validation.HousingValidator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/housing")
public class HousingController {
    private final HousingService housingService;
    private final HousingValidator validator;
    @GetMapping("/search-housing")
      public List<Housing> searchHousing(City city){
         return housingService.searchHousing(city);
      }

      @GetMapping("/add-default")
    public void createDefaultHousing(){
        housingService.addDefault();
      }

      @GetMapping("/get-all")
    public List<HousingDTO>getAllHousingDTO(){
        return housingService.getAllHousingDTO();
      }

      @PostMapping("/add-housing")
    public HousingDTO addNewHousing(@RequestBody HousingDTO housingDTO, BindingResult bindingResult){
        validator.validate(housingDTO, bindingResult);

          if (bindingResult.hasErrors()){
              throw new ValidationException();
          }
          return housingService.addNewHousing(housingDTO);
      }
    @DeleteMapping("/delete-housing")
    public void deleteHousing(UUID id){
        housingService.deleteHousing(id);
    }
    @GetMapping("/search-housings")
    public  List<Housing> searchHousing(City city, Country country, LocalDate due_date, Integer price, Integer rating){
        return housingService.searchHousing(city,country,due_date,price,rating);
    }

    @PutMapping("/edit")
    public HousingDTO edit(@RequestBody HousingDTO housingDTO){
        return housingService.editHousing(housingDTO);
    }
}
