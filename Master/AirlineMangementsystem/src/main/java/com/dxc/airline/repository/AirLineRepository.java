package com.dxc.airline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxc.airline.model.AirLine;

public interface AirLineRepository extends JpaRepository<AirLine, Long> {

	List<AirLine> findByAirlineid(Long id);

}
