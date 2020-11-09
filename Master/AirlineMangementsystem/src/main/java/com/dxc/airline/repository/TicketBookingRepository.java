package com.dxc.airline.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dxc.airline.model.TicketBooking;

@Repository
public interface TicketBookingRepository extends JpaRepository<TicketBooking, Long> {
	
	@Query(value = "select max(ticket_id) from ticket_booking;", nativeQuery = true)
    long LastEnteredTicket();

}
