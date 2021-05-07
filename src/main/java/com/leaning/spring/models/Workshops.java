 package com.leaning.spring.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "workshops")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Workshops {
	public Workshops() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long workshop_id;
	private String workshop_name;
	private String description;
	private String requirements;
	private String room;
	private int capacity;

	public Long getWorkshop_id() {
		return workshop_id;
	}

	public void setWorkshop_id(Long workshop_id) {
		this.workshop_id = workshop_id;
	}

	public String getWorkshop_name() {
		return workshop_name;
	}

	public void setWorkshop_name(String workshop_name) {
		this.workshop_name = workshop_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRequirements() {
		return requirements;
	}

	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

}
