package org.example.springboot.service;

import lombok.RequiredArgsConstructor;


import org.example.springboot.dto.UserDTO;

import org.example.springboot.entity.Housing;
import org.example.springboot.entity.User;
import org.example.springboot.enums.City;
import org.example.springboot.enums.Country;

import org.example.springboot.mapper.UserMapper;

import org.example.springboot.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public void addDefault(){
        User user = User.builder()
                .surname("Varfolomeev")
                .username("ilya")
                .patronymic("Sergeevich")
                .city("Sochi")
                .country(Country.Russia)
                .nick("Admin")
                .password("bfgfgfgfgfgh")
                .userdate(LocalDate.of(2004,2,15))
                .email("gfhfhvhfhfh.com")

                .build();
            User savedEntity = userRepository.save(user);
        System.out.println("Успешно сохранена сущность " + savedEntity);
    }


    public List<UserDTO> getAllUserDTO(){
        return userRepository.findAll().stream()
                .map(user -> transformToDto(user))
                .collect(Collectors.toList());
    }
    private UserDTO transformToDto(User user){
       return UserDTO.builder()
                .id(user.getId())
                 .username(user.getUsername())
                .surname(user.getSurname())
                .patronymic(user.getPatronymic())
                .city(user.getCity())
                .country(user.getCountry())
                .nick(user.getNick())
                .password(String.valueOf(user.getPassword()))
                .userdate(user.getUserdate())
                .email(user.getEmail())
                .build();
    }

    @Transactional
    public UserDTO addNewUser(UserDTO userDTO) {

        User user = User.builder()
                .surname(userDTO.getSurname())
                .username(userDTO.getUsername())
                .patronymic(userDTO.getPatronymic())
                .city(userDTO.getCity())
                .country(userDTO.getCountry())
                .nick(userDTO.getNick())
                .password(String.valueOf(userDTO.getPassword()))
                .userdate(userDTO.getUserdate())
                .email(userDTO.getEmail())
                .build();
        User savedEntity = userRepository.save(user);
        return userMapper.toDto(savedEntity);
    }
    public void deleteUser(UUID id){
        userRepository.deleteById(id);
    }
     public UserDTO editUser(UserDTO userDTO) {
       User user = User.builder()
                       .id(userDTO.getId())
                       .surname(userDTO.getSurname())
                       .username(userDTO.getUsername())
                       .patronymic(userDTO.getPatronymic())
                       .city(userDTO.getCity())
                       .country(userDTO.getCountry())
                       .nick(userDTO.getNick())
                       .password(String.valueOf(userDTO.getPassword()))
                       .email(userDTO.getEmail())
                       .build();
       return transformToDto(userRepository.save(user));

     }
//    public Optional<User> getUserByName(String username){
//        return userRepository.findByName(username);
//   }


}
