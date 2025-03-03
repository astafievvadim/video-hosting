package com.astafievvadim.authservice.auth;

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
    private UserRepo repository;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User registerNewUserAccount(SignUpRequest sup) {
            if(!emailExists(sup.getEmail())) {
                throw new RuntimeException();
            }

        User user = new User();
        user.setUsername(sup.getUsername());
        user.setPassword(passwordEncoder.encode(sup.getPassword()));
        user.setEmail(sup.getEmail());
        user.setRoles(Collections.singletonList(roleRepo.findByRole("ROLE_USER")));

        return repository.save(user);
    }

    private boolean emailExists(String email) {
        return repository.findByEmail(email).isPresent();
    }
}
