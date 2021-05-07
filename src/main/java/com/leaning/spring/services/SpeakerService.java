package com.leaning.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leaning.spring.domain.SpeakerDomain;
import com.leaning.spring.domain.WorkshopDomain;
import com.leaning.spring.models.Speaker;
import com.leaning.spring.models.WorkshopSpeakers;
import com.leaning.spring.models.Workshops;
import com.leaning.spring.repositories.SpeakerRepository;
import com.leaning.spring.repositories.WorkshopRepository;
import com.leaning.spring.repositories.WorkshopSpeakersRepository;

@Service
public class SpeakerService {
	@Autowired
	private SpeakerRepository speakerRepository;
	@Autowired
	private WorkshopRepository workshopRepository;
	@Autowired
	private WorkshopSpeakersRepository workshopSpeakersRepository;

	public List<SpeakerDomain> getSpeakers() {
		
		List<Speaker> speakerList = speakerRepository.findAll();
		List<SpeakerDomain> speakerDomainList = new ArrayList<SpeakerDomain>();
		List<WorkshopSpeakers> workshopSpeakersList = workshopSpeakersRepository.findAll();
		
		for (Speaker speaker : speakerList) {
			SpeakerDomain speakerDomain = new SpeakerDomain();
			speakerDomain.setSpeakerId(speaker.getSpeaker_id().intValue());
			speakerDomain.setFirstName(speaker.getFirst_name());
			speakerDomain.setLastName(speaker.getLast_name());
			speakerDomain.setTitle(speaker.getTitle());
			speakerDomain.setCompany(speaker.getCompany());
			List<WorkshopDomain> workshopDomainList = new ArrayList<WorkshopDomain>();
			for (WorkshopSpeakers workshopSpeakers : workshopSpeakersList) {
				if (speaker.getSpeaker_id() == workshopSpeakers.getSpeaker_id()) {
					Workshops workshop = workshopRepository.getOne(Long.valueOf(workshopSpeakers.getWorkshop_id()));
					WorkshopDomain workshopDomain = new WorkshopDomain();
					workshopDomain.setCapacity(workshop.getCapacity());
					workshopDomain.setDescription(workshop.getDescription());
					workshopDomain.setRoom(workshop.getRoom());
					workshopDomain.setWorkshopId(workshop.getWorkshop_id());
					workshopDomain.setWorkshopName(workshop.getWorkshop_name());
					workshopDomainList.add(workshopDomain);
				}
			}
			speakerDomain.setWorkshops(workshopDomainList);
			speakerDomainList.add(speakerDomain);

		}
		return speakerDomainList;
	}

	
	  /*public List<SpeakerDomain> getSpeakers() {
	  
	  List<SpeakerDomain> speakerDomainList = new ArrayList<SpeakerDomain>();
	  
	  List<Speaker> speakerList = speakerRepository.findAll();
	  List<SessionSpeakers> sessionSpeakersList =
	  sessionSpeakersRepository.findAll();
	  
	  for (Speaker speaker : speakerList) { SpeakerDomain speakerDomain = new
	  SpeakerDomain();
	  
	  speakerDomain.setSpeakerId(speaker.getSpeaker_id().intValue());
	  speakerDomain.setFirstName(speaker.getFirst_name());
	  speakerDomain.setLastName(speaker.getLast_name());
	 speakerDomain.setTitle(speaker.getTitle());
	  speakerDomain.setCompany(speaker.getCompany()); List<SessionDomain>
	 sessionDomainList = new ArrayList<SessionDomain>(); //
	  speakerDomainList.add(speakerDomain); for (SessionSpeakers sessionSpeakers :
	  sessionSpeakersList) { if (speaker.getSpeaker_id() ==
	  sessionSpeakers.getSpeaker_id()) { Session session =
	  sessionRepository.getOne(Long.valueOf(sessionSpeakers.getSession_id()));
	  SessionDomain sessionDomain = new SessionDomain();
	  sessionDomain.setSessionId(session.getSession_id().intValue());
	  sessionDomain.setSessionName(session.getSession_name());
	  sessionDomain.setSessionDescription(session.getSession_description());
	  sessionDomain.setSessionLength(session.getSession_length());
	  sessionDomainList.add(sessionDomain); }
	  
	  } speakerDomain.setSessions(sessionDomainList);
	  speakerDomainList.add(speakerDomain); }
	  
	  return speakerDomainList; 
	  }*/
	 

	public SpeakerDomain postSpeaker(SpeakerDomain speakerDomain) {

		Speaker speaker = new Speaker();
		speaker.setFirst_name(speakerDomain.getFirstName());
		speaker.setLast_name(speakerDomain.getLastName());
		speaker.setCompany(speakerDomain.getCompany());
		speaker.setSpeaker_bio("test");
		speaker.setTitle(speakerDomain.getTitle());
		speaker.setSpeaker_photo(null);

		Speaker addedSpeaker = speakerRepository.saveAndFlush(speaker);

		SpeakerDomain addedSpeakerDomain = new SpeakerDomain();
		addedSpeakerDomain.setCompany(addedSpeaker.getCompany());
		addedSpeakerDomain.setFirstName(addedSpeaker.getFirst_name());
		addedSpeakerDomain.setLastName(addedSpeaker.getLast_name());
		addedSpeakerDomain.setTitle(addedSpeaker.getTitle());
		addedSpeakerDomain.setSpeakerId(addedSpeaker.getSpeaker_id().intValue());
		return addedSpeakerDomain;

	}

	public SpeakerDomain putSpeaker(SpeakerDomain speakerDomain) {
		Speaker speaker = new Speaker();
		speaker.setSpeaker_id(Long.valueOf(speakerDomain.getSpeakerId()));
		speaker.setFirst_name(speakerDomain.getFirstName());
		speaker.setLast_name(speakerDomain.getLastName());
		speaker.setCompany(speakerDomain.getCompany());
		speaker.setSpeaker_bio("test");
		speaker.setTitle(speakerDomain.getTitle());
		speaker.setSpeaker_photo(null);

		Speaker addedSpeaker = speakerRepository.saveAndFlush(speaker);

		SpeakerDomain addedSpeakerDomain = new SpeakerDomain();
		addedSpeakerDomain.setCompany(addedSpeaker.getCompany());
		addedSpeakerDomain.setFirstName(addedSpeaker.getFirst_name());
		addedSpeakerDomain.setLastName(addedSpeaker.getLast_name());
		addedSpeakerDomain.setTitle(addedSpeaker.getTitle());
		addedSpeakerDomain.setSpeakerId(addedSpeaker.getSpeaker_id().intValue());
		return addedSpeakerDomain;

	}

}
