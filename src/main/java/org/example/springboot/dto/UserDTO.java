package org.example.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.springboot.enums.Country;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private UUID id;
    private String surname;
    private String username;
    private String patronymic;
    private String city;
    private Country country;
    private String nick;
    private String password;
    private LocalDate userdate;
    private String email;


}
