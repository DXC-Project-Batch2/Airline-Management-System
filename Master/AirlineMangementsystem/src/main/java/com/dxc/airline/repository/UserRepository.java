package com.dxc.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxc.airline.model.User;

public interface UserRepository extends JpaRepository<User, String> {
	User findByUsernameAndPassword(String username, String password);
}

