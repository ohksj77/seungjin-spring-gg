package com.example.seungjinspringgg.repository;

import com.example.seungjinspringgg.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByName(String name);

    Optional<User> findByProviderAndProviderId(String provider, String providerId);

}
