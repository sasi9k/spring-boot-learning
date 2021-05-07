package com.leaning.spring.domain;

import java.util.List;

public class SessionDomain {
	
	private int sessionId;

	private String sessionName;
	
	private String sessionDescription;
	
	private int sessionLength;
	
	private SpeakerDomain speaker;
	
	

	public SpeakerDomain getSpeaker() {
		return speaker;
	}

	public void setSpeaker(SpeakerDomain speaker) {
		this.speaker = speaker;
	}

	public int getSessionId() {
		return sessionId;
	}

	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}

	public String getSessionName() {
		return sessionName;
	}

	public void setSessionName(String sessionName) {
		this.sessionName = sessionName;
	}

	public String getSessionDescription() {
		return sessionDescription;
	}

	public void setSessionDescription(String sessionDescription) {
		this.sessionDescription = sessionDescription;
	}

	public int getSessionLength() {
		return sessionLength;
	}

	public void setSessionLength(int sessionLength) {
		this.sessionLength = sessionLength;
	}


}
