package com.example.springapp.service;

import java.util.List;

import com.example.springapp.model.Attendee;


public interface AttendeeService {

	 public boolean createAttendee(Attendee e);
	 public boolean updateAttendee( Attendee e);
	 public boolean deleteAttendee(Long id);
	 public List<Attendee> getAllAttendee();
	  public Attendee getAttendeeById(Long id);
	  public List<Attendee> getAttendeeByEventId(Long eventId);
}
