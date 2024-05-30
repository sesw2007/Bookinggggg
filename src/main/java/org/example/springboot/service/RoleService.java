package org.example.springboot.service;

import lombok.RequiredArgsConstructor;
import org.example.springboot.dto.RoleDTO;
import org.example.springboot.entity.Role;
import org.example.springboot.enums.RoleType;
import org.example.springboot.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleService {
     private final RoleRepository roleRepository;

     public void addRole(RoleDTO role){
         roleRepository.save(Role.builder()
                 .roleType(RoleType.fromString(role.getRole()))
                 .build());
     }

     public List<Role> findAll(){
         return roleRepository.findAll();
   }

    public void getRoles(List<UUID> roleIds){
        roleIds.stream()
                .map(roleRepository ::findById)
                .map(Optional::get)
                .collect(Collectors.toSet());
    }
}
