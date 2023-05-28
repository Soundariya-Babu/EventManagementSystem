package com.example.springapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springapp.model.Ticket;

@Repository
public interface TicketRepo extends JpaRepository<Ticket, Long> {

	public List<Ticket> findByEventId(Long eventId);
	public List<Ticket> findByAttendeeId(Long attendeeId);

}
