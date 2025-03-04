package com.astafievvadim.authservice.auth.service;

import com.astafievvadim.authservice.auth.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private UserRepo userRepo;

    @Autowired
    public AuthService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


}
