package org.example.springboot.service;

import lombok.RequiredArgsConstructor;


import org.example.springboot.dto.HousingDTO;
import org.example.springboot.entity.Housing;
import org.example.springboot.enums.City;
import org.example.springboot.enums.Country;
import org.example.springboot.mapper.HousingMapper;
import org.example.springboot.repository.HousingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class HousingService {
    private final HousingRepository housingRepository;
    private final HousingMapper housingMapper;
    private List<Housing> housings;

    public  List<Housing> searchHousing(City city) {
      housings = housings.stream()
              .filter(housing -> housing.getCity().equals(city.name().toLowerCase().contains(city.name().toLowerCase())))
              .toList();
      return housings;
    }

    public void addDefault(){
         Housing housing = Housing.builder()
                .name("квартира")
                .city(City.valueOf("Moscow"))
                 .country(Country.Russia)
                .availability_communications("вода горячая, газ отопления")
                .build();
        Housing savedEntity = housingRepository.save(housing);
        System.out.println("Успешно сохранена сущность " + savedEntity);
    }

    public List<HousingDTO> getAllHousingDTO(){
        return housingRepository.findAll().stream()
                .map(housing -> transformToDto(housing))
                .collect(Collectors.toList());
    }

    private HousingDTO transformToDto(Housing housing){
        return HousingDTO.builder()
                .id(housing.getId())
                .name(housing.getName())
                .city(housing.getCity())
                .availability_communications(housing.getAvailability_communications())
                .build();
    }

    @Transactional
    public HousingDTO addNewHousing(HousingDTO housingDTO){
        Housing housing = Housing.builder()
                .name(housingDTO.getName())
                .city(housingDTO.getCity())
                .country(housingDTO.getCountry())
                .availability_communications(housingDTO.getAvailability_communications())
                .build();
         Housing savedEntity = housingRepository.save(housing);
         return housingMapper.toDto(savedEntity);
    }

    public void deleteHousing(UUID id){
        housingRepository.deleteById(id);
    }
    public Optional<Housing> getHousingByName(String name) {
        return housingRepository.findByName(name);
    }
    public  List<Housing> searchHousing(City city, Country country, LocalDate due_date, Integer price, Integer rating){
     housings = housings.stream()
             .filter(housing -> housing.getCity().equals(city.name().toLowerCase().contains(city.name().toLowerCase())))
             .filter(housing -> housing.getCountry().equals(country.name().toLowerCase().contains(country.name().toLowerCase())))
             .filter(housing -> housing.getDue_date().equals(due_date.plusDays(1)))
             .filter(housing -> housing.getPrice().equals(price.intValue()))
             .filter(housing -> housing.getRating().equals(rating.intValue()))
             .toList();
     return housings;
    }
    public HousingDTO editHousing(HousingDTO housingDTO){
        Housing housing = Housing.builder()
                .id(housingDTO.getId())
                .name(housingDTO.getName())
                .rating(housingDTO.getRating())
                .due_date(housingDTO.getDue_date())
                .price(housingDTO.getPrice())
                .country(housingDTO.getCountry())
                .city(housingDTO.getCity())
                .build();
        return transformToDto(housingRepository.save(housing));
    }
}
