package com.leaning.spring.models;



import javax.persistence.Entity;

import javax.persistence.Id;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name="session_speakers")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SessionSpeakers {
	@Id
	private int session_id;
	private int speaker_id;

	
	public int getSession_id() {
		return session_id;
	}
	public void setSession_id(int session_id) {
		this.session_id = session_id;
	}
	public int getSpeaker_id() {
		return speaker_id;
	}
	public void setSpeaker_id(int speaker_id) {
		this.speaker_id = speaker_id;
	}

}
