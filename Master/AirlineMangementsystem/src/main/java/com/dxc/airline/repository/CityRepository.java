package com.dxc.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxc.airline.model.City;

public interface CityRepository extends JpaRepository<City, String> {

}
