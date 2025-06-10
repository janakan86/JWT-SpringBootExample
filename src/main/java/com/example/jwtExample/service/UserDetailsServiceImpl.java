package com.example.jwtExample.service;

import com.example.jwtExample.domain.AppUser;
import com.example.jwtExample.repository.AppUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;

import org.springframework.stereotype.Service;

import java.util.Optional;

/*
 Spring security uses the implementation of the UserDetailService to authenticate and authorize the user
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AppUserRepository repository;

    public UserDetailsServiceImpl(AppUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> retrievedUser = repository.findAppUserByUserName(username);
        UserBuilder builder = null;

        // retrieve the saves user details and construct a Spring User object using the details if the username is valid
        if(retrievedUser.isPresent()){
            builder = org.springframework.security.core.userdetails.User.withUsername(username);

            builder.password(retrievedUser.get().getPassword());
            builder.roles(retrievedUser.get().getUserName());
        }
        else{
            throw new UsernameNotFoundException("User Not Found");
        }
        return builder.build();
    }
}
