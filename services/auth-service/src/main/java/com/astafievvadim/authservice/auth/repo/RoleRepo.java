package com.astafievvadim.authservice.auth.repo;


import com.astafievvadim.authservice.auth.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface RoleRepo extends JpaRepository<Role, Serializable> {
    Role findRoleByRole(String role);
}
