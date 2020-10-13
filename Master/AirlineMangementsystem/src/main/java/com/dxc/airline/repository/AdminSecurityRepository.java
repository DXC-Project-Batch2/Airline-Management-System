package com.dxc.airline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxc.airline.model.AdminSecurity;

public interface AdminSecurityRepository extends JpaRepository<AdminSecurity , String >{
//	List<AdminSecurity> findByUsername(String username);
}