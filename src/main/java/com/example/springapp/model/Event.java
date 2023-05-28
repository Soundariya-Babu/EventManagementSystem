package com.example.springapp.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "event")
public class Event {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "startDate")
	private Date startDate;

	@Column(name = "endDate")
	private Date endDate;

	@Column(name = "location")
	private String location;

	@Column(name = "totalTicket")
	private Long totalTicket;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Attendee> attendee;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Ticket> ticket;

	
	public Event() {
		super();
	}

	public Event(Long id, String name, String description, Date startDate, Date endDate, String location,
			Long totalTickets) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.location = location;
		this.totalTicket = totalTickets;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Long getTotalTickets() {
		return totalTicket;
	}

	public void setTotalTickets(Long totalTickets) {
		this.totalTicket = totalTickets;
	}

	@JsonIgnore
	public List<Attendee> getAttendee() {
		return attendee;
	}

	public void setAttendee(List<Attendee> attendee) {
		this.attendee = attendee;
	}

	@JsonIgnore
	public List<Ticket> getTicket() {
		return ticket;
	}

	public void setTicket(List<Ticket> ticket) {
		this.ticket = ticket;
	}

}
