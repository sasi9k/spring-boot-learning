package com.leaning.spring.models;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name="sessions")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Session {
	
	public Session() {
		
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="session_id")
	private Long sessionId;
	
	@Column(name="session_name")
	private String sessionName;
	
	@Column(name="session_description")
	private String sessionDescription;
	
	@Column(name="session_length")
	private Integer sessionLength;
	
	
	
	
	public Long getSession_id() {
		return sessionId;
	}
	public void setSession_id(Long session_id) {
		this.sessionId = session_id;
	}
	public String getSession_name() {
		return sessionName;
	}
	public void setSession_name(String session_name) {
		this.sessionName = session_name;
	}
	public String getSession_description() {
		return sessionDescription;
	}
	public void setSession_description(String session_description) {
		this.sessionDescription = session_description;
	}
	public Integer getSession_length() {
		return sessionLength;
	}
	public void setSession_length(Integer session_length) {
		this.sessionLength = session_length;
	}
	

}
