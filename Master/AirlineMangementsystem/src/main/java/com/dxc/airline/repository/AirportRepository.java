package com.dxc.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dxc.airline.model.Airport;

@Repository
public interface AirportRepository extends JpaRepository<Airport, String> {
	
	Airport findByAirportCode(String airportcode);

}
