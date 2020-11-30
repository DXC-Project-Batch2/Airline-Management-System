package com.dxc.airline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dxc.airline.model.Sample_model;

public interface JasperRepo extends JpaRepository<Sample_model, String> {

	@Query(value = "select t.ticket_id,t.source,t.destination,t.date,t.no_of_passengers,p.name,p.username,p.flight_id,p.age,p.gender,a.carrier_name,a.duration,a.starting_time,a.ending_time from ticket_booking t inner join passenger p on t.ticket_id =p.ticket_id and t.flight_id= p.flight_id inner join air_line a on t.flight_id=a.plane_id and t.date=a.date where t.ticket_id=(select max(ticket_id) from ticket_booking);", nativeQuery = true)
    List<Sample_model> sampleModel();
}
