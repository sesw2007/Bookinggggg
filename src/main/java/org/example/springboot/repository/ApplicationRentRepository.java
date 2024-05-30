package org.example.springboot.repository;


import org.example.springboot.entity.ApplicationRent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ApplicationRentRepository extends JpaRepository<ApplicationRent, UUID> {

    Optional<ApplicationRent> findByName(String name);
}
