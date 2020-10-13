package com.dxc.airline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxc.airline.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, String> {
	List<Admin> findByUsername(String username);
}
