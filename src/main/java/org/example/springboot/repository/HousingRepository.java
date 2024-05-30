package org.example.springboot.repository;

import org.example.springboot.entity.Housing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface HousingRepository extends JpaRepository<Housing, UUID> {
    Optional<Housing> findByName(String name);
}
