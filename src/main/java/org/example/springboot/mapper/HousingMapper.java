package org.example.springboot.mapper;

import org.example.springboot.dto.HousingDTO;
import org.example.springboot.entity.Housing;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface HousingMapper {
  HousingDTO toDto(Housing housing);
  Housing  toEntity(HousingDTO housingDTO);
  Housing merge(HousingDTO dto, @MappingTarget Housing target);
}
