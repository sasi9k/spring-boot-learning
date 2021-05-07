package com.leaning.spring.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name="attendee_tickets")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AttendeeTickets {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long attendee_ticket_id;
	private int attendee_id;
	private int ticket_price_id;
	private int discount_code_id;
	private float net_price;
	public long getAttendee_ticket_id() {
		return attendee_ticket_id;
	}
	public void setAttendee_ticket_id(long attendee_ticket_id) {
		this.attendee_ticket_id = attendee_ticket_id;
	}
	public int getAttendee_id() {
		return attendee_id;
	}
	public void setAttendee_id(int attendee_id) {
		this.attendee_id = attendee_id;
	}
	public int getTicket_price_id() {
		return ticket_price_id;
	}
	public void setTicket_price_id(int ticket_price_id) {
		this.ticket_price_id = ticket_price_id;
	}
	public int getDiscount_code_id() {
		return discount_code_id;
	}
	public void setDiscount_code_id(int discount_code_id) {
		this.discount_code_id = discount_code_id;
	}
	public float getNet_price() {
		return net_price;
	}
	public void setNet_price(float net_price) {
		this.net_price = net_price;
	}

}
