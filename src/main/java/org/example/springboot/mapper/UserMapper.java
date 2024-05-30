package org.example.springboot.mapper;

import org.example.springboot.dto.UserDTO;
import org.example.springboot.entity.User;
import org.mapstruct.*;
@Mapper(componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)

public interface UserMapper {

      UserDTO toDto(User user);

      User toEntity(UserDTO userDTO);

      User marge(UserDTO dto, @MappingTarget User entity);
}
