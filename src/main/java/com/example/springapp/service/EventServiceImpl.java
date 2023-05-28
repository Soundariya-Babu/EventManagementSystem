package com.example.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.Event;
import com.example.springapp.repository.EventRepo;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventRepo repo;
	
	@Override
	public boolean createEvent(Event e) {
		return repo.save(e)!= null ? true : false;
	}

	@Override
	public boolean updateEvent(Event e) {
		if(repo.existsById(e.getId()))
		{
			return repo.save(e)!= null ? true : false;

		}
		return false;
	}

	@Override
	public boolean deleteEvent(Long id) {
		if(repo.existsById(id))
		{
			repo.deleteById(id);
			return true;
		}
		return false;
	}
	
	@Override
	public List<Event> getAllEvent() {

		List<Event> list= repo.findAll();
		return list;
	}

	@Override
	public Event getEventById(Long id) {

		if(repo.existsById(id))
		{
			Event ex=repo.findById(id).get();
			return ex;
		}
		return null;
	}

}
