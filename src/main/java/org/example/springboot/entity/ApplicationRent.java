package org.example.springboot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table( name = "applicationrent")
public class ApplicationRent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @OneToOne
    @JoinColumn(name = "housing_id")
    private Housing housing;
    @Column(name = "price")
    private Integer price;
    @Column(name = "rating")
    private Integer rating;
    @Column(name = "name")
    private String name;
}
