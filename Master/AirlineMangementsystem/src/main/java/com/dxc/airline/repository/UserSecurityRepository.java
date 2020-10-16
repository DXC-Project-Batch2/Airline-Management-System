package com.dxc.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dxc.airline.model.UserSecurity;

@Repository
public interface UserSecurityRepository extends JpaRepository<UserSecurity, String> {

}
