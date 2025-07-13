package com.example.jwtExample.filter;

import com.example.jwtExample.config.SecurityConfig;
import com.example.jwtExample.service.JWTService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class AuthenticationFilter extends OncePerRequestFilter {

    private final JWTService jwtService;

    AuthenticationFilter(JWTService jwtService) {
        this.jwtService = jwtService;
    }


    //authenticates incoming JWT tokens
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String jwt = request.getHeader(HttpHeaders.AUTHORIZATION);


        if (jwt != null) {
            String username = jwtService.getUserNameFromToken(request);
            Authentication authentication = new UsernamePasswordAuthenticationToken(username, null,
                    java.util.Collections.emptyList());

            SecurityContextHolder.getContext().setAuthentication(authentication);

        }

        filterChain.doFilter(request, response);

    }
}
