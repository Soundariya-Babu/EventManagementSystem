package com.example.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springapp.model.Event;

@Repository
public interface EventRepo extends JpaRepository<Event, Long> {

}
