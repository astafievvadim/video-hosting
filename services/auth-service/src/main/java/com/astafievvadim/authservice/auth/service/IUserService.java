package com.astafievvadim.authservice.auth.service;

import com.astafievvadim.authservice.auth.model.User;
import com.astafievvadim.authservice.payload.SignUpRequest;

public interface IUserService {
    User registerNewUserAccount(SignUpRequest signUpRequest);
}