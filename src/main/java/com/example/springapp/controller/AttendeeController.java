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

import com.example.springapp.model.Attendee;
import com.example.springapp.service.AttendeeService;

@RestController
@RequestMapping("/attendee")
public class AttendeeController {

	@Autowired
	private AttendeeService service;

	@PostMapping
	public ResponseEntity<String> save(@RequestBody Attendee p) {

		boolean s = service.createAttendee(p);
		if (s) {
			return new ResponseEntity<>("Attendee created", HttpStatus.CREATED);
		}
		return new ResponseEntity<>("Already present", HttpStatus.ALREADY_REPORTED);
	}

	@PutMapping
	public ResponseEntity<String> update(@RequestBody Attendee e) {

		boolean s = service.updateAttendee(e);
		if (s) {
			return new ResponseEntity<>("updated", HttpStatus.CREATED);
		}
		return new ResponseEntity<>("Attendee not found", HttpStatus.NOT_FOUND);
	}

	@DeleteMapping
	public ResponseEntity<Boolean> delete(@RequestParam Long id) {

		boolean s = service.deleteAttendee(id);
		if (s) {
			return new ResponseEntity<>(s, HttpStatus.OK);
		}
		return new ResponseEntity<>(s, HttpStatus.NOT_FOUND);
	}

	@GetMapping
	public ResponseEntity<List<Attendee>> getAll() {

		List<Attendee> p = service.getAllAttendee();
		return new ResponseEntity<>(p, HttpStatus.OK);
	}

	@GetMapping("/id")
	public ResponseEntity<Attendee> getById(@RequestParam Long id) {

		Attendee w = service.getAttendeeById(id);
		if (w == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(w, HttpStatus.OK);
	}

	@GetMapping("/eventId")
	public ResponseEntity<List<Attendee>> getByEventId(@RequestParam Long eventId) {

		List<Attendee> p = service.getAttendeeByEventId(eventId);
		return new ResponseEntity<>(p, HttpStatus.OK);
	}

}
