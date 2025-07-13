package com.example.jwtExample.controller;


import com.example.jwtExample.domain.LoginRequestCredentials;
import com.example.jwtExample.service.JWTService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;


    public LoginController(AuthenticationManager authenticationManager, JWTService jwtService){
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @PostMapping ("/login")
    public ResponseEntity<?> getToken(@RequestBody LoginRequestCredentials credentials){
        UsernamePasswordAuthenticationToken credentialsToken = new UsernamePasswordAuthenticationToken(credentials.username(),credentials.password());

        Authentication authentication = authenticationManager.authenticate(credentialsToken);

        if (authentication.isAuthenticated()){

            //generate a JWT Token
            String jwtToken = jwtService.generateJWTToken(authentication.getName(),null);

            // Build response with the generated token
            return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION,
                    "Bearer " + jwtToken).header(HttpHeaders.
                            ACCESS_CONTROL_EXPOSE_HEADERS,
                    "Authorization").build();
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed");
    }
}
