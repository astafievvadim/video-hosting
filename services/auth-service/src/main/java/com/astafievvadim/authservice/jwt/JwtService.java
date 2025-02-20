package com.astafievvadim.authservice.jwt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    @Value("${application.security.jwt.secret-key}")
    private String secretKey;
    @Value("${application.security.jwt.expiration}")
    private Long jwtExpiration;
    @Value("${application.security.jwt.refresh-token.expiration}")
    private Long refreshExpiration;

    /*

    _____________
    | put       |
    | something |
    |   here... |
    -------------

    */

}
