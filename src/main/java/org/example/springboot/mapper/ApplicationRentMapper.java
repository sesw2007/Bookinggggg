package org.example.springboot.mapper;

import org.example.springboot.dto.ApplicationRentDTO;
import org.example.springboot.dto.HousingDTO;
import org.example.springboot.entity.ApplicationRent;
import org.example.springboot.entity.Housing;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ApplicationRentMapper {
    ApplicationRentDTO toDto(ApplicationRent applicationRent);
    ApplicationRent  toEntity(ApplicationRentDTO applicationRentDTO);
    ApplicationRent merge(ApplicationRentDTO dto, @MappingTarget ApplicationRent target);
}
