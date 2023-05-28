package com.example.springapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springapp.model.Attendee;

@Repository
public interface AttendeeRepo extends JpaRepository<Attendee, Long> {

	public List<Attendee> findByEventId(Long eventId);
}
