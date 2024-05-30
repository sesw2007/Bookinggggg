package org.example.springboot.controller;

import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.example.springboot.dto.ApplicationRentDTO;
import org.example.springboot.service.ApplicationRentService;
import org.example.springboot.validation.ApplicationRentValidator;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/applicationrent")
public class ApplicationRentController {
        private final ApplicationRentService applicationRentService;
        private final ApplicationRentValidator applicationRentValidator;

        @GetMapping("/add-default")
    public void createDefaultApplicationRent(){
        applicationRentService.addDefault();
    }
    @GetMapping("/get-all")
    public List<ApplicationRentDTO> getAllApplicationRentDTO(){
        return applicationRentService.getAllApplicationRentDTO();
    }

    @PostMapping("/add-applicationrent")
    public ApplicationRentDTO addNewApplicationRent(@RequestBody ApplicationRentDTO applicationRentDTO, BindingResult bindingResult ){
     applicationRentValidator.validate(applicationRentDTO, bindingResult );
        if (bindingResult.hasErrors()){
            throw new ValidationException();
        }
        return applicationRentService.addNewApplicationRent(applicationRentDTO);
    }

    @DeleteMapping("/delete-application")
    public  void deleteApplicationRent(UUID id){
            applicationRentService.deleteApplication(id);
    }

    @PutMapping("/edit")
    public ApplicationRentDTO edit(@RequestBody ApplicationRentDTO applicationRentDTO){
            return applicationRentService.editApplicationRent(applicationRentDTO);
    }
}
