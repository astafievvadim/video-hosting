package com.astafievvadim.authservice.auth.controller;

import com.astafievvadim.authservice.auth.model.User;
import com.astafievvadim.authservice.auth.service.UserService;
import com.astafievvadim.authservice.payload.SignInRequest;
import com.astafievvadim.authservice.payload.SignUpRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/auth")
public class AuthController  {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody SignUpRequest sup) {

        try {
            userService.registerNewUserAccount(sup);
            return new ResponseEntity<>("aok", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("err", HttpStatus.BAD_REQUEST);
        }

    }
    @PostMapping("/login")
    public ResponseEntity<?> signIn(@RequestBody SignInRequest sir){

        Authentication auth = null;
        try{
            auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(sir.getUsername(), sir.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(auth);

            User a = userService.getUserByUsername(sir.getUsername());
            return ResponseEntity.ok(a);

        } catch (BadCredentialsException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/logout")
    public ResponseEntity<?> signOut(HttpServletRequest request, HttpServletResponse response){
        Authentication auth = null;
        try{
            auth = SecurityContextHolder.getContext().getAuthentication();
            return new ResponseEntity<>("asss", HttpStatus.OK);
        } catch (BadCredentialsException e){
            new SecurityContextLogoutHandler().logout(request, response, auth);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
