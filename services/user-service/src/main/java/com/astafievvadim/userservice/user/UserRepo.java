package com.astafievvadim.userservice.user;

import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface UserRepo extends JpaRepository<User, Serializable> {
}
