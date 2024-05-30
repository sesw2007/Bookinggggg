package org.example.springboot.mapper;

import org.example.springboot.dto.PlaceAdsDTO;
import org.example.springboot.entity.PlaceAds;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface PlaceAdsMapper {
    PlaceAdsDTO toDo(PlaceAds placeAds);
    PlaceAds toEntity(PlaceAdsDTO placeAdsDTO);
     PlaceAds merge(PlaceAdsDTO dto, @MappingTarget PlaceAds target);
}
