package com.dxc.airline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.dxc.airline.model.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Integer> {
	 
	@Query(value = "SELECT * FROM passenger WHERE username = :username", nativeQuery = true)
    List<Passenger> findByUserName(@Param("username") String username);

	@Query(value = "SELECT * FROM passenger WHERE username = :username AND flight_id = :flightId", nativeQuery = true)
    List<Passenger> findByUser(@Param("username") String username, @Param("flightId") int flightId);
	
}
