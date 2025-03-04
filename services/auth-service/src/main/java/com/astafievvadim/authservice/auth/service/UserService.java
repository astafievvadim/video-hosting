package com.astafievvadim.authservice.auth.service;


import com.astafievvadim.authservice.auth.repo.RoleRepo;
import com.astafievvadim.authservice.auth.model.User;
import com.astafievvadim.authservice.auth.repo.UserRepo;
import com.astafievvadim.authservice.payload.SignUpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
@Transactional
public class UserService implements IUserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User getUserByUsername(String username) {
        return userRepo.findByUsername(username).orElseThrow();
    }

    @Override
    public User registerNewUserAccount(SignUpRequest sup) {
            if(emailExists(sup.getEmail())) {
                throw new RuntimeException();
            }

        User user = new User();
        user.setUsername(sup.getUsername());
        user.setPassword(passwordEncoder.encode(sup.getPassword()));
        user.setEmail(sup.getEmail());
        user.setRoles(Collections.singletonList
                (roleRepo.findRoleByRole("ROLE_USER")));

        return userRepo.save(user);
    }

    private boolean emailExists(String email) {
        return userRepo.findByEmail(email).isPresent();
    }
}
