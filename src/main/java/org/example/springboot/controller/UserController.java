package org.example.springboot.controller;

import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.example.springboot.dto.UserDTO;
import org.example.springboot.service.UserService;
//import org.example.springboot.validation.UserValidator;
import org.example.springboot.validation.UserValidator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserValidator validator;

    @GetMapping("/add-default")
      public void createDefaultUser(){
          userService.addDefault();
      }

    @GetMapping("/get-all")
     public List<UserDTO> getAllUserDTO(){
      return userService.getAllUserDTO();
     }
    @PostMapping("/add-user")
    public UserDTO addNewUser(@RequestBody UserDTO userDTO ){
       return userService.addNewUser(userDTO);
//     validator.validate(userDTO, bindingResult);
//
//     if (bindingResult.hasErrors()){
//         throw new ValidationException();
//     }
//     return userService.addNewUser(userDTO);
    }
    @DeleteMapping("/delete-user")
    public void deleteUser( UUID id){
        userService.deleteUser(id);
    }
    @PutMapping("/edit")
    public UserDTO edit(@RequestBody UserDTO userDTO){
        return userService.editUser(userDTO);
    }

}
