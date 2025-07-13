package com.example.jwtExample.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.Map;

@Component
public class JWTService {

    //key is stored here for demonstration purposes only
    static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    static final String PREFIX = "Bearer";


    long expirationMillis = 86400000; // 1 day
    Date expirationDate = new Date(new Date().getTime() + expirationMillis);


    public String generateJWTToken(String userName, Map<String, Object> extraClaims) {
        String jwtToken = Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userName)
                .setIssuedAt(new Date(new Date().getTime()))
                .setExpiration(expirationDate)
                .signWith(key).
                compact();

        return jwtToken;
    }


    public String getUserNameFromToken(HttpServletRequest request) {
        String jwtToken = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (jwtToken != null) {
            String userName = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwtToken.replace(PREFIX, "")
            ).getBody().getSubject();

            return userName;

        }
        return null;
    }

}
