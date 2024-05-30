package org.example.springboot.repository;

import org.example.springboot.entity.Housing;
import org.example.springboot.entity.PlaceAds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface PlaceAdsRepository extends JpaRepository<PlaceAds, UUID> {
    Optional<PlaceAds> findByName(String name);
}
