package com.example.springapp.service;

import java.util.List;

import com.example.springapp.model.Event;


public interface EventService {

	 public boolean createEvent(Event e);
	 public boolean updateEvent( Event e);
	 public boolean deleteEvent(Long id);
	 public List<Event> getAllEvent();
	 public Event getEventById(Long id);
}
