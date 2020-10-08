package com.dxc.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxc.airline.model.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

}

