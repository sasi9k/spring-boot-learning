package com.leaning.spring.models;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name="time_slots")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class TimeSlots {
	public TimeSlots() {
		
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long time_slot_id;
	private Time start_time;
	private Date time_slot_date;
	private Time end_time;
	private Byte is_keynote_time_slot;
	public Long getTime_slot_id() {
		return time_slot_id;
	}
	public void setTime_slot_id(Long time_slot_id) {
		this.time_slot_id = time_slot_id;
	}
	public Time getStart_time() {
		return start_time;
	}
	public void setStart_time(Time start_time) {
		this.start_time = start_time;
	}
	public Date getTime_slot_date() {
		return time_slot_date;
	}
	public void setTime_slot_date(Date time_slot_date) {
		this.time_slot_date = time_slot_date;
	}
	public Time getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Time end_time) {
		this.end_time = end_time;
	}
	public Byte getIs_keynote_time_slot() {
		return is_keynote_time_slot;
	}
	public void setIs_keynote_time_slot(Byte is_keynote_time_slot) {
		this.is_keynote_time_slot = is_keynote_time_slot;
	}
	

}
