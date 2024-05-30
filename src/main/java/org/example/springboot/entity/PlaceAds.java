package org.example.springboot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "placeads")
public class PlaceAds {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "name")
    private String name;
    @OneToOne
    @JoinColumn(name = "housing_id")
    private Housing housing;
    @Column(name = "the_nearest_stop_metro")
    private  String the_nearest_stop_metro;
    @Column(name = "due_date")
    private LocalDate due_date;
    @Column(name = "rating")
    private Integer rating;
    @Column(name = "activity")
    private boolean activity;
}
