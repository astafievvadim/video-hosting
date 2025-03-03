package com.astafievvadim.authservice.auth;

import com.astafievvadim.authservice.payload.SignOutRequest;
import com.astafievvadim.authservice.payload.SignInRequest;
import com.astafievvadim.authservice.payload.SignUpRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.csrf.CsrfToken;
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
    public ResponseEntity<?> signUp(@RequestBody SignUpRequest sign) {
        try {
            User registered = userService.registerNewUserAccount(sign);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("err", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("aok", HttpStatus.OK);
    }
    @PostMapping("/login")
    public ResponseEntity<?> signIn(@RequestBody SignInRequest sir){

        Authentication auth = null;
        try{
            auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(sir.getUsername(), sir.getPassword()));
        } catch (BadCredentialsException e){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        SecurityContextHolder.getContext().setAuthentication(auth);
        return ResponseEntity.ok("Signed in successfully");
    }
    @PostMapping("/logout")
    public ResponseEntity<?> signOut(HttpServletRequest request, HttpServletResponse response){
        Authentication auth = null;
        try{
            auth = SecurityContextHolder.getContext().getAuthentication();
        } catch (BadCredentialsException e){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return new ResponseEntity<>("asss", HttpStatus.OK);
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){ // CsrfToken provide by spring security.
        //generate token
        return (CsrfToken)request.getAttribute("_csrf");
    }
}
