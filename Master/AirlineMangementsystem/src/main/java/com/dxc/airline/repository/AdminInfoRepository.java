package com.dxc.airline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxc.airline.model.AdminInfo;


public interface AdminInfoRepository extends JpaRepository<AdminInfo, String> {

	List<AdminInfo> findByUsername(String username);
}
