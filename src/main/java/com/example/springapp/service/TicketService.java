package com.example.springapp.service;

import java.util.List;

import com.example.springapp.model.Event;
import com.example.springapp.model.Ticket;
import com.example.springapp.model.TicketSales;


public interface TicketService {

	 public boolean createTicket(Ticket e);
	 public boolean updateTicket( Ticket e);
	 public boolean deleteTicket(Long id);
	 public List<Ticket> getAllTicket();
	 public Ticket getTicketById(Long id);
	 public List<Ticket> getTicketByEventId(Long eventId);
	 public List<Ticket> getTicketByAttendeeId(Long attendeeId);
	 public TicketSales getSalesByEventId(Long eventId);

}
