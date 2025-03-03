package com.astafievvadim.authservice.auth;

import com.astafievvadim.authservice.payload.SignUpRequest;

public interface IUserService {
    User registerNewUserAccount(SignUpRequest signUpRequest);
}