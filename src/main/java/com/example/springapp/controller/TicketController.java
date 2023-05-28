package com.example.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.Ticket;
import com.example.springapp.model.TicketSales;
import com.example.springapp.service.TicketService;

@RestController
@RequestMapping("/ticket")
public class TicketController {

	@Autowired
	private TicketService service;

	@PostMapping
	public ResponseEntity<String> save(@RequestBody Ticket p) {

		boolean s = service.createTicket(p);
		if (s) {
			return new ResponseEntity<>("Ticket Booked", HttpStatus.CREATED);
		}
		return new ResponseEntity<>("Tickets full", HttpStatus.ALREADY_REPORTED);
	}

	@PutMapping
	public ResponseEntity<String> update(@RequestBody Ticket e) {

		boolean s = service.updateTicket(e);
		if (s) {
			return new ResponseEntity<>("updated", HttpStatus.CREATED);
		}
		return new ResponseEntity<>("Ticket not found", HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/id")
	public ResponseEntity<Boolean> delete(@RequestParam Long id) {

		boolean s = service.deleteTicket(id);
		if (s) {
			return new ResponseEntity<>(s, HttpStatus.OK);
		}
		return new ResponseEntity<>(s, HttpStatus.NOT_FOUND);
	}

	@GetMapping
	public ResponseEntity<List<Ticket>> getAll() {

		List<Ticket> p = service.getAllTicket();
		return new ResponseEntity<>(p, HttpStatus.OK);
	}

	@GetMapping("/id")
	public ResponseEntity<Ticket> getById(@RequestParam Long id) {

		Ticket w = service.getTicketById(id);
		if (w == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(w, HttpStatus.OK);
	}

	@GetMapping("/eventId")
	public ResponseEntity<List<Ticket>> getByEventId(@RequestParam Long eventId) {

		List<Ticket> p = service.getTicketByEventId(eventId);
		return new ResponseEntity<>(p, HttpStatus.OK);
	}
	
	@GetMapping("/sales-report/eventId")
	public ResponseEntity<TicketSales> getSalesEventId(@RequestParam Long eventId) {

	TicketSales sales = service.getSalesByEventId(eventId);
	if (sales == null) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	return new ResponseEntity<>(sales, HttpStatus.OK);
	
	}

	@GetMapping("/attendeeId")
	public ResponseEntity<List<Ticket>> getByAttendeeId(@RequestParam Long attendeeId) {

		List<Ticket> p = service.getTicketByEventId(attendeeId);
		return new ResponseEntity<>(p, HttpStatus.OK);
	}
}
