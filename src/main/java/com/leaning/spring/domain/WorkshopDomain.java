package com.leaning.spring.domain;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(Include.NON_NULL)
public class WorkshopDomain {
	
	private Long workshopId;
	private String workshopName;
	private String description;
	private String requirements;
	private String room;
	private int capacity;
	private List<AttendeeTicketsDomain> attendeeTickets;
	@JsonInclude(Include.NON_NULL)
	private List<SpeakerDomain> speakers;
	
	public List<AttendeeTicketsDomain> getAttendeeTickets() {
		return attendeeTickets;
	}

	public void setAttendeeTickets(List<AttendeeTicketsDomain> attendeeTickets) {
		this.attendeeTickets = attendeeTickets;
	}

	public List<SpeakerDomain> getSpeakers() {
		return speakers;
	}

	public void setSpeakers(List<SpeakerDomain> speakers) {
		this.speakers = speakers;
	}

	public Long getWorkshopId() {
		return workshopId;
	}

	public void setWorkshopId(Long workshopId) {
		this.workshopId = workshopId;
	}

	public String getWorkshopName() {
		return workshopName;
	}

	public void setWorkshopName(String workshopName) {
		this.workshopName = workshopName;
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
