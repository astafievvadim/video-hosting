package com.astafievvadim.authservice.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private AuthRepo authRepo;

    @Autowired
    public AuthService(AuthRepo authRepo) {
        this.authRepo = authRepo;
    }


}
