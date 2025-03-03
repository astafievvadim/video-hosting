package com.astafievvadim.authservice.auth;

import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Serializable> {
    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);
}
