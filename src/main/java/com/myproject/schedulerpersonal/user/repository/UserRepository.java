package com.myproject.schedulerpersonal.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.schedulerpersonal.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findUserById(Long id);
}
