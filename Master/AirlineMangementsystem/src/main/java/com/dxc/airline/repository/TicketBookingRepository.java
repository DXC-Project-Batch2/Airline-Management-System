package com.dxc.airline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dxc.airline.model.TicketBooking;

@Repository
public interface TicketBookingRepository extends JpaRepository<TicketBooking, Long> {

	List<TicketBooking> findByTicketId(Long city);
}
