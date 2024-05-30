package org.example.springboot.dto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.springboot.enums.City;
import org.example.springboot.enums.Country;

import java.time.LocalDate;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HousingDTO {

    private UUID id;
    private String name;
    private City city;
    private Country country;
    private Integer rating;
    private String availability_communications;
    private Integer price;
    private LocalDate due_date;
}
