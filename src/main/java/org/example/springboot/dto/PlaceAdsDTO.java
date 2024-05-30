package org.example.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.springboot.entity.Housing;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlaceAdsDTO {

    private UUID id;
    private String name;
    private Housing housing;
    private Integer rating;
    private  String the_nearest_stop_metro;
    private LocalDate due_date;
    private boolean activity;
}
