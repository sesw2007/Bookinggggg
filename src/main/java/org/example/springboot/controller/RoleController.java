package org.example.springboot.controller;

import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.example.springboot.dto.RoleDTO;
import org.example.springboot.service.RoleService;
import org.example.springboot.validation.RoleValidator;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/roles")
public class RoleController {
    private final RoleService roleService;
    private final RoleValidator validator;

    @PostMapping
    public void addRole(@RequestBody RoleDTO roleDTO, BindingResult bindingResult ){
        validator.validate(roleDTO, bindingResult);
        if (bindingResult.hasErrors()){
            throw new ValidationException("Уже присутствует роль " + roleDTO);
        }
         roleService.addRole(roleDTO);
    }
}
