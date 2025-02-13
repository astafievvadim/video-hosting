package com.astafievvadim.authservice.auth;

import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface AuthRepo extends JpaRepository<AuthUser, Serializable> {
}
