package org.example.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.springboot.entity.Housing;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplicationRentDTO {
    private UUID id;
    private Housing housing;
    private Integer price;
    private Integer rating;
    private String name;
}
