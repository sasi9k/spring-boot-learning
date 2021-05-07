package com.leaning.spring.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name="workshop_speakers")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class WorkshopSpeakers {
	@Id
	private int workshop_id;
	private int speaker_id;
	public int getWorkshop_id() {
		return workshop_id;
	}
	public void setWorkshop_id(int workshop_id) {
		this.workshop_id = workshop_id;
	}
	public int getSpeaker_id() {
		return speaker_id;
	}
	public void setSpeaker_id(int speaker_id) {
		this.speaker_id = speaker_id;
	}

}
