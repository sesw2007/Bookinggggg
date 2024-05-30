package org.example.springboot.repository;


import org.example.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User,UUID> {

//    Optional<User> findByName(String username);
    @Query("FROM User u JOIN FETCH u.roles WHERE u.username = :username")
    Optional<User>findByUsername(String username);


}
