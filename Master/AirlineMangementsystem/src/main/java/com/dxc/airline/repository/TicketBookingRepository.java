package com.dxc.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxc.airline.model.TicketBooking;

public interface TicketBookingRepository extends JpaRepository<TicketBooking, String> {

}
