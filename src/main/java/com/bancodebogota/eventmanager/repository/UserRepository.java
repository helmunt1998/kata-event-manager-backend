package com.bancodebogota.eventmanager.repository;

import org.springframework.stereotype.Repository;

import com.bancodebogota.eventmanager.entity.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByNick(String username);
}
