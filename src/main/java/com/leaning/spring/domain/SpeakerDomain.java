package com.leaning.spring.domain;

import java.util.List;

public class SpeakerDomain {
	private int speakerId;
	private String firstName;
	private String lastName;
	private String title;
	private String company;
	private String bio;
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	private List<WorkshopDomain> workshops;
	
	public List<WorkshopDomain> getWorkshops() {
		return workshops;
	}
	public void setWorkshops(List<WorkshopDomain> workshops) {
		this.workshops = workshops;
	}
	public int getSpeakerId() {
		return speakerId;
	}
	public void setSpeakerId(int speakerId) {
		this.speakerId = speakerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	

}
