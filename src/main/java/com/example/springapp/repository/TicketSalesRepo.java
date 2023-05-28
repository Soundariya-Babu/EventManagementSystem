package com.example.springapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springapp.model.Ticket;
import com.example.springapp.model.TicketSales;

@Repository
public interface TicketSalesRepo extends JpaRepository<TicketSales, Long> {

	public TicketSales findByEventId(Long eventId);

}
