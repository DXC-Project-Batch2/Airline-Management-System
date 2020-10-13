package com.dxc.airline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dxc.airline.model.UserSecurity;

@Repository
public interface UserSecurityRepository extends JpaRepository<UserSecurity, String> {
	List<UserSecurity> findByUsername(String username);
}
