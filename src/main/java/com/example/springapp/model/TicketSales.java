package com.example.springapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ticket_sales")
public class TicketSales {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="totalTicketsBooked")
	private Long totalTicketsBooked;
	@Column(name="totalPrice")
	private Double totalPrice;
	@Column(name="eventId")
	private Long eventId;
	@Column(name="availableTicktes")
	private Long availableTicktes;
	@Column(name="noOfAttendees")
	private Long noOfAttendees;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getTotalTicketsBooked() {
		return totalTicketsBooked;
	}
	public void setTotalTicketsBooked(Long totalTicketsBooked) {
		this.totalTicketsBooked = totalTicketsBooked;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Long getEventId() {
		return eventId;
	}
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}
	public Long getAvailableTicktes() {
		return availableTicktes;
	}
	public void setAvailableTicktes(Long availableTicktes) {
		this.availableTicktes = availableTicktes;
	}
	public Long getNoOfAttendees() {
		return noOfAttendees;
	}
	public void setNoOfAttendees(Long noOfAttendees) {
		this.noOfAttendees = noOfAttendees;
	}
	
	
	
	
	

}
