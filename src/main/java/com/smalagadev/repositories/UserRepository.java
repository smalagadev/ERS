package com.smalagadev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smalagadev.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
