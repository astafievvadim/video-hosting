package com.astafievvadim.authservice.auth;

import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface RoleRepo extends JpaRepository<Role, Serializable> {
    Role findByRole(String role_user);
}
