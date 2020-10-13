package com.dxc.airline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxc.airline.model.City;

public interface CityRepository extends JpaRepository<City, String> {

	List<City> findBycity(String city);
	
}

