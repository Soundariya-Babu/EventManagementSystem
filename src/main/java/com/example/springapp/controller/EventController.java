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

import com.example.springapp.model.Event;
import com.example.springapp.service.EventService;

@RestController
@RequestMapping("/event")
public class EventController {

	@Autowired
	private EventService service;

	@PostMapping
	public ResponseEntity<String> save(@RequestBody Event p) {

		boolean s = service.createEvent(p);
		if (s) {
			return new ResponseEntity<>("Event created", HttpStatus.CREATED);
		}
		return new ResponseEntity<>("Already present", HttpStatus.ALREADY_REPORTED);
	}

	@PutMapping
	public ResponseEntity<String> update(@RequestBody Event e) {

		boolean s = service.updateEvent(e);
		if (s) {
			return new ResponseEntity<>("updated", HttpStatus.CREATED);
		}
		return new ResponseEntity<>("Event not found", HttpStatus.NOT_FOUND);
	}

	@DeleteMapping
	public ResponseEntity<Boolean> delete(@RequestParam Long id) {

		boolean s = service.deleteEvent(id);
		if (s) {
			return new ResponseEntity<>(s, HttpStatus.OK);
		}
		return new ResponseEntity<>(s, HttpStatus.NOT_FOUND);
	}

	@GetMapping
	public ResponseEntity<List<Event>> getAll() {

		List<Event> p = service.getAllEvent();
		return new ResponseEntity<>(p, HttpStatus.OK);
	}

	@GetMapping("/id")
	public ResponseEntity<Event> getById(@RequestParam Long id) {

		Event w = service.getEventById(id);
		if (w == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(w, HttpStatus.OK);
	}

}
