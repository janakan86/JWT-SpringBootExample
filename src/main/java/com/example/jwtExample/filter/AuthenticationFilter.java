package com.example.jwtExample.filter;

import com.example.jwtExample.config.SecurityConfig;
import com.example.jwtExample.service.JWTService;
import com.example.jwtExample.service.UserDetailsServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class AuthenticationFilter extends OncePerRequestFilter {

    private final JWTService jwtService;
    private final UserDetailsServiceImpl userDetailsService;

    AuthenticationFilter(JWTService jwtService, UserDetailsServiceImpl userDetailsService) {
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;

    }


    //authenticates incoming JWT tokens
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String jwt = request.getHeader(HttpHeaders.AUTHORIZATION);


        if (jwt != null) {
            String username = jwtService.getUserNameFromToken(request);
            List<SimpleGrantedAuthority> authorities = new ArrayList<>();

            /* adding the Role as an authority since Role can be considered as a coarse-grained GrantedAuthority */
            authorities.add(new SimpleGrantedAuthority("ROLE_"+this.userDetailsService.getRoleForUser(username)));

            Authentication authentication = new UsernamePasswordAuthenticationToken(username,
                    null,
                    authorities);

            SecurityContextHolder.getContext().setAuthentication(authentication);

        }

        filterChain.doFilter(request, response);

    }
}
