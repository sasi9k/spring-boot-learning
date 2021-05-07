package com.leaning.spring.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name="workshop_registrations")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class WorkshopRegistration {

	private int workshop_id;
	@Id
	private int attendee_ticket_id;
	
	public int getWorkshop_id() {
		return workshop_id;
	}
	public void setWorkshop_id(int workshop_id) {
		this.workshop_id = workshop_id;
	}
	public int getAttendee_ticket_id() {
		return attendee_ticket_id;
	}
	public void setAttendee_ticket_id(int attendee_ticket_id) {
		this.attendee_ticket_id = attendee_ticket_id;
	}

}
