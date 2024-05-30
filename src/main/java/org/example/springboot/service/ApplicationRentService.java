package org.example.springboot.service;

import lombok.RequiredArgsConstructor;
import org.example.springboot.dto.ApplicationRentDTO;
import org.example.springboot.entity.ApplicationRent;
import org.example.springboot.entity.Housing;
import org.example.springboot.enums.City;
import org.example.springboot.mapper.ApplicationRentMapper;
import org.example.springboot.repository.ApplicationRentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApplicationRentService {
       private final ApplicationRentRepository  applicationRentRepository;
       private final ApplicationRentMapper applicationRentMapper;
    public void addDefault() {
        ApplicationRent applicationRent = ApplicationRent.builder()
                .name("Название аренды")
                .price(150000)
                .housing(Housing.builder()
                        .name("дом")
                        .city(City.valueOf("Crimea"))
                        .availability_communications("вода горячая, газ отопления")
                        .build())
                .rating(1-10)
                .build();
        ApplicationRent savedEntity = applicationRentRepository.save(applicationRent);
        System.out.println("Успешно сохранена сущность " + savedEntity);
    }
   public List<ApplicationRentDTO> getAllApplicationRentDTO() {
       return applicationRentRepository.findAll().stream()
               .map(applicationRent -> transformToDto(applicationRent))
               .collect(Collectors.toList());
   }

   private ApplicationRentDTO  transformToDto(ApplicationRent applicationRent){
        return ApplicationRentDTO.builder()
                .id(applicationRent.getId())
                .housing(applicationRent.getHousing())
                .name(applicationRent.getName())
                .price(applicationRent.getPrice())
                .rating(applicationRent.getRating())
                .build();
   }
    @Transactional
    public ApplicationRentDTO addNewApplicationRent(ApplicationRentDTO applicationRentdto){
        ApplicationRent applicationRent = ApplicationRent.builder()
                .housing(applicationRentdto.getHousing())
                .name(applicationRentdto.getName())
                .rating(applicationRentdto.getRating())
                .price(applicationRentdto.getPrice())
                .build();
        ApplicationRent savedEntity = applicationRentRepository.save(applicationRent);
        return applicationRentMapper.toDto(savedEntity);
    }
    public void deleteApplication(UUID id){
        applicationRentRepository.deleteById(id);
    }
    public ApplicationRentDTO editApplicationRent(ApplicationRentDTO applicationRentDTO){
        ApplicationRent applicationRent = ApplicationRent.builder()
                .id(applicationRentDTO.getId())
                .housing(applicationRentDTO.getHousing())
                .price(applicationRentDTO.getPrice())
                .name(applicationRentDTO.getName())
                .build();

        return transformToDto(applicationRentRepository.save(applicationRent));
    }
   public Optional<ApplicationRent> getApplicationRentByName(String name) {
      return applicationRentRepository.findByName(name);
    }
}
