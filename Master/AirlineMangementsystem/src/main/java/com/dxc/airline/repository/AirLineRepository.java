package com.dxc.airline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dxc.airline.model.AirLine;

public interface AirLineRepository extends JpaRepository<AirLine, Integer> {
	
	@Query(value = "SELECT * FROM air_line WHERE source = :source AND destination = :destination", nativeQuery = true)
    List<AirLine> findByCities(@Param("source") String source, @Param("destination") String destination);

}
