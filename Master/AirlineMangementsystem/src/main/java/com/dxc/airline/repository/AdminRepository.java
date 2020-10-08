package com.dxc.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.dxc.airline.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
