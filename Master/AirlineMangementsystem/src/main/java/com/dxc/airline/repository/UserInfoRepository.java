package com.dxc.airline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxc.airline.model.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, String> {

	List<UserInfo> findByUsername(String username);
}

