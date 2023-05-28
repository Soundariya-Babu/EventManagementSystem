package com.example.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.Attendee;
import com.example.springapp.model.Event;
import com.example.springapp.model.Ticket;
import com.example.springapp.model.TicketSales;
import com.example.springapp.repository.AttendeeRepo;
import com.example.springapp.repository.EventRepo;
import com.example.springapp.repository.TicketRepo;
import com.example.springapp.repository.TicketSalesRepo;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepo repo;

	@Autowired
	private TicketSalesRepo salesrepo;

	@Autowired
	private AttendeeRepo attendeerepo;

	@Autowired
	private EventRepo eventrepo;

	@Override
	public boolean createTicket(Ticket e) {

		Long eventId = e.getEvent().getId();
		List<Ticket> tickets = repo.findByEventId(eventId);
		Event event = eventrepo.findById(eventId).get();
		Long totaltickets = event.getTotalTickets();
		Long count = (long) (tickets.size());
		System.out.println(count);
		System.out.println(totaltickets);

		if (totaltickets > count) {
			Ticket t = repo.save(e);
			TicketSales ts = new TicketSales();
			ts = salesrepo.findByEventId(eventId);
			
			TicketSales sales=new TicketSales();
			if (ts!=null) {
				sales.setId(ts.getId());
				sales.setEventId(t.getEvent().getId());
				sales.setAvailableTicktes(totaltickets);
				sales.setTotalTicketsBooked((long) (count+1));

				List<Attendee> attendees = attendeerepo.findByEventId(t.getEvent().getId());
				sales.setNoOfAttendees((long) (attendees.size()));
				long value=ts.getTotalTicketsBooked()+1;
				Double totalPrice = t.getPrice()*value;
				sales.setTotalPrice(totalPrice);
				System.out.println(totalPrice);

				salesrepo.save(sales);
				return true;
			} else {
				
				sales.setEventId(t.getEvent().getId());
				sales.setAvailableTicktes(totaltickets);
				sales.setTotalTicketsBooked((long) (count+1));

				List<Attendee> attendees = attendeerepo.findByEventId(t.getEvent().getId());
				sales.setNoOfAttendees((long) (attendees.size()));
				Double totalPrice = t.getPrice();
				sales.setTotalPrice(totalPrice);
				System.out.println(totalPrice);

				salesrepo.save(sales);
				return true;

			}

		}
		return false;
	}

	@Override
	public boolean updateTicket(Ticket e) {
		if (repo.existsById(e.getId())) {
			return repo.save(e) != null ? true : false;

		}
		return false;
	}

	@Override
	public boolean deleteTicket(Long id) {
		if (repo.existsById(id)) {
			repo.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public List<Ticket> getAllTicket() {

		List<Ticket> list = repo.findAll();
		return list;
	}

	@Override
	public Ticket getTicketById(Long id) {

		if (repo.existsById(id)) {
			Ticket ex = repo.findById(id).get();
			return ex;
		}
		return null;
	}

	@Override
	public List<Ticket> getTicketByEventId(Long eventId) {

		List<Ticket> list = repo.findByEventId(eventId);
		return list;
	}
	
	@Override
	public TicketSales getSalesByEventId(Long eventId) {

		TicketSales sales = salesrepo.findByEventId(eventId);
		return sales;
	}
	

	@Override
	public List<Ticket> getTicketByAttendeeId(Long attendeeId) {

		List<Ticket> list = repo.findByAttendeeId(attendeeId);
		return list;
	}

}
