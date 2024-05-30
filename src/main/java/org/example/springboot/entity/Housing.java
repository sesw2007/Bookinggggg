package org.example.springboot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.springboot.enums.City;
import org.example.springboot.enums.Country;

import java.time.LocalDate;
import java.util.UUID;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "housing")
public class Housing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "name")
    private String name;
    @Column(name = "city")
    private City city;
    @Column(name = "availability_communications")
    private String availability_communications;
    @Column(name = "country")
    private Country country;
    @Column(name = "rating")
    private Integer rating;
    @Column(name = "price")
    private Integer price;
    @Column(name = "due_date")
    private LocalDate due_date;


    public City getCity(){
        return city;
    }
}
