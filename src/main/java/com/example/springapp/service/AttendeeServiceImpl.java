package com.example.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.Attendee;
import com.example.springapp.repository.AttendeeRepo;

@Service
public class AttendeeServiceImpl implements AttendeeService {

	@Autowired
	private AttendeeRepo repo;
	
	@Override
	public boolean createAttendee(Attendee e) {
		return repo.save(e)!= null ? true : false;
	}

	@Override
	public boolean updateAttendee(Attendee e) {
		if(repo.existsById(e.getId()))
		{
			return repo.save(e)!= null ? true : false;

		}
		return false;
	}

	@Override
	public boolean deleteAttendee(Long id) {
		if(repo.existsById(id))
		{
			repo.deleteById(id);
			return true;
		}
		return false;
	}
	
	@Override
	public List<Attendee> getAllAttendee() {

		List<Attendee> list= repo.findAll();
		return list;
	}

	@Override
	public Attendee getAttendeeById(Long id) {

		if(repo.existsById(id))
		{
			Attendee ex=repo.findById(id).get();
			return ex;
		}
		return null;
	}

	@Override
	public List<Attendee> getAttendeeByEventId(Long eventId) {

		List<Attendee> list= repo.findByEventId(eventId);
		return list;
	}
}
