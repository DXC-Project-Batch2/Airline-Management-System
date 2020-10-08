package com.dxc.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxc.airline.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

}
