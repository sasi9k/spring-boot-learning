package com.leaning.spring.models;

import java.util.List;



public class UserData {
	private String sessionName;
	private String speakerName;
	private List<WorkshopDetails> workshopDetails;
	
	public List<WorkshopDetails> getWorkshopDetails() {
		return workshopDetails;
	}
	public void setWorkshopDetails(List<WorkshopDetails> workshopDetails) {
		this.workshopDetails = workshopDetails;
	}
	public String getSessionName() {
		return sessionName;
	}
	public void setSessionName(String sessionName) {
		this.sessionName = sessionName;
	}
	public String getSpeakerName() {
		return speakerName;
	}
	public void setSpeakerName(String speakerName) {
		this.speakerName = speakerName;
	}
	
	
	

}
