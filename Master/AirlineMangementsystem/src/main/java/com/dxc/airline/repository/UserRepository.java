package com.dxc.airline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxc.airline.model.User;

public interface UserRepository extends JpaRepository<User, String> {
	
	List<User> findByUsername(String username);

}

