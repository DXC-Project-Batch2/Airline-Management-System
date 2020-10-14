package com.dxc.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dxc.airline.model.ScheduleFlight;

@Repository
public interface ScheduleFlightRepository extends JpaRepository<ScheduleFlight,Integer> {

}
