package org.example.springboot.service;

import lombok.RequiredArgsConstructor;

import org.example.springboot.dto.PlaceAdsDTO;
import org.example.springboot.entity.Housing;
import org.example.springboot.entity.PlaceAds;
import org.example.springboot.enums.City;
import org.example.springboot.mapper.PlaceAdsMapper;
import org.example.springboot.repository.PlaceAdsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlaceAdsService {
    private final PlaceAdsRepository placeAdsRepository;
    private  final PlaceAdsMapper placeAdsMapper;
    public void addDefault(){
        PlaceAds placeAds = PlaceAds.builder()
                .due_date(LocalDate.of(2023, 2, 28))
                .the_nearest_stop_metro("красная звезда, локомотив")
                .name("Название обьявления")
                .rating(1-5)
                .housing(Housing.builder()
                        .name("квартира")
                        .city(City.valueOf("Moscow"))
                        .availability_communications("вода горячая, газ отопления")
                        .build())
                .build();
        PlaceAds savedEntity = placeAdsRepository.save(placeAds);
        System.out.println("Успешно сохранена сущность " + savedEntity);
    }

    public List<PlaceAdsDTO> getAllPlaceAdsDTO(){
        return placeAdsRepository.findAll().stream()
                .map(placeAds ->transformToDto(placeAds) )
                .collect(Collectors.toList());
    }
    private PlaceAdsDTO transformToDto(PlaceAds placeAds){
        return PlaceAdsDTO.builder()
                .id(placeAds.getId())
                .name(placeAds.getName())
                .due_date(placeAds.getDue_date())
                .rating(placeAds.getRating())
                .housing(placeAds.getHousing())
                .build();
    }

    @Transactional
    public PlaceAdsDTO addNewPlaceAds(PlaceAdsDTO placeAdsDTO){
        PlaceAds placeAds = PlaceAds.builder()
                .name(placeAdsDTO.getName())
                .housing(placeAdsDTO.getHousing())
                .rating(placeAdsDTO.getRating())
                .the_nearest_stop_metro(placeAdsDTO.getThe_nearest_stop_metro())
                .due_date(placeAdsDTO.getDue_date())
                .build();
        PlaceAds savedEntity = placeAdsRepository.save(placeAds);
        return placeAdsMapper.toDo(savedEntity);
    }
    public PlaceAdsDTO editApplicationRent(PlaceAdsDTO placeAdsDTO){
        PlaceAds placeAds = PlaceAds.builder()
                .id(placeAdsDTO.getId())
                .rating(placeAdsDTO.getRating())
                .the_nearest_stop_metro(placeAdsDTO.getThe_nearest_stop_metro())
                .build();
        return transformToDto(placeAdsRepository.save(placeAds));
    }
    public void deletePlaceAds(UUID id){
        placeAdsRepository.deleteById(id);
    }

    public Optional<PlaceAds> getPlaceAdsByName(String name) {
        return placeAdsRepository.findByName(name);
    }
    public boolean activityPlaceAds(){
        if (true){
            System.out.println("Снимают жилье");
        }else {
            System.out.println("обьявления  активное");
        }
        if (false){
            System.out.println("Не снимают жилье");
        }else {
            System.out.println("обьявления не активное");
        }
        return  false;

    }
}
