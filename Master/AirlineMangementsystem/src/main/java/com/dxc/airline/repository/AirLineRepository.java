package com.dxc.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxc.airline.model.AirLine;

public interface AirLineRepository extends JpaRepository<AirLine, Long> {

}
