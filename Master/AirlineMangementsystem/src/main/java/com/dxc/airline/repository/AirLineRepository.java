package com.dxc.airline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.dxc.airline.model.AirLine;

public interface AirLineRepository extends JpaRepository<AirLine, Integer> {
	
	@Query(value = "SELECT * FROM air_line WHERE source = :source AND destination = :destination", nativeQuery = true)
    List<AirLine> findByCities(@Param("source") String source, @Param("destination") String destination);
	
	@Query(value = "SELECT * FROM air_line WHERE source = :source AND destination = :destination AND date = :date", nativeQuery = true)
    List<AirLine> findByUser(@Param("source") String source, @Param("destination") String destination,
	@Param("date") String date);

	@Query(value = "SELECT * FROM air_line WHERE plane_id = :plane_id", nativeQuery = true)
	List<AirLine> findAllById(@Param("plane_id")int plane_id);
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM air_line WHERE plane_id = :plane_id", nativeQuery = true)
	void deleteByPlane_Id(@Param("plane_id")int plane_id);

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM air_line WHERE date < :date", nativeQuery = true)
	void deleteByDate(@Param("date")String date);

}
