package com.example.jwtExample.repository;

import com.example.jwtExample.domain.AppUser;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AppUserRepository extends CrudRepository<AppUser,Long> {
    Optional<AppUser> findAppUserByUserName(String userName);
}
