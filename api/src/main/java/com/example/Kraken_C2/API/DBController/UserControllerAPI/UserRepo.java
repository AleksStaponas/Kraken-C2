package com.example.Kraken_C2.API.DBController.UserControllerAPI;

import com.example.Kraken_C2.API.DBController.UserControllerAPI.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<com.example.Kraken_C2.API.DBController.UserControllerAPI.User, Long> {
    Optional<User> findByUsername(String username);
}