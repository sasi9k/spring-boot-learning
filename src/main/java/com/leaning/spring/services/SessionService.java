package com.leaning.spring.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.leaning.spring.domain.SessionDomain;
import com.leaning.spring.domain.SpeakerDomain;
import com.leaning.spring.models.UserData;
import com.leaning.spring.models.WorkshopDetails;
import com.leaning.spring.models.WorkshopRegistration;
import com.leaning.spring.models.AttendeeTickets;
import com.leaning.spring.models.Session;
import com.leaning.spring.models.SessionSpeakers;
import com.leaning.spring.models.Speaker;
import com.leaning.spring.models.WorkshopSpeakers;
import com.leaning.spring.models.Workshops;
import com.leaning.spring.repositories.AttendeeTicketsRepository;
import com.leaning.spring.repositories.SessionRepository;
import com.leaning.spring.repositories.SessionSpeakersRepository;
import com.leaning.spring.repositories.SpeakerRepository;
import com.leaning.spring.repositories.WorkshopRegistrationRepository;
import com.leaning.spring.repositories.WorkshopRepository;
import com.leaning.spring.repositories.WorkshopSpeakersRepository;

@Service
public class SessionService {
	@Autowired
	private SpeakerRepository speakerRepository;
	@Autowired
	private SessionSpeakersRepository sessionSpeakersRepository;
	@Autowired
	private SessionRepository sessionRepository;
	@Autowired
	private WorkshopSpeakersRepository workshopSpeakersRepository;
	@Autowired
	private WorkshopRepository workshopRepository;
	@Autowired
	private WorkshopRegistrationRepository workshopRegistrationRepository;
	@Autowired
	private AttendeeTicketsRepository attendeeTicketsRepository;

	public List<SessionDomain> getSessions() {

		List<SessionDomain> sessionDomainList = new ArrayList<SessionDomain>();
		List<SessionSpeakers> sessionSpeakersList = sessionSpeakersRepository.findAll();

		List<Session> sessionList = sessionRepository.findAll();
		for (Session session : sessionList) {
			SessionDomain sessionDomain = new SessionDomain();
			sessionDomain.setSessionId(session.getSession_id().intValue());
			sessionDomain.setSessionName(session.getSession_name());
			sessionDomain.setSessionDescription(session.getSession_description());
			sessionDomain.setSessionLength(session.getSession_length());

			for (SessionSpeakers sessionSpeakers : sessionSpeakersList) {
				if (session.getSession_id() == sessionSpeakers.getSession_id()) {
					Speaker speaker = speakerRepository.getOne(Long.valueOf(sessionSpeakers.getSpeaker_id()));
					SpeakerDomain speakerDomain = new SpeakerDomain();
					speakerDomain.setSpeakerId(speaker.getSpeaker_id().intValue());
					speakerDomain.setFirstName(speaker.getFirst_name());
					speakerDomain.setLastName(speaker.getLast_name());
					speakerDomain.setTitle(speaker.getTitle());
					speakerDomain.setCompany(speaker.getCompany());
					sessionDomain.setSpeaker(speakerDomain);
				}
			}

			sessionDomainList.add(sessionDomain);
		}

		return sessionDomainList;
	}

	public SessionDomain postSession(SessionDomain sessionDomain) {

		Session session = new Session();
		session.setSession_name(sessionDomain.getSessionName());
		session.setSession_description(sessionDomain.getSessionDescription());
		session.setSession_length(sessionDomain.getSessionLength());
		Session addedSession = sessionRepository.saveAndFlush(session);

		Speaker speaker = new Speaker();
		speaker.setFirst_name(sessionDomain.getSpeaker().getFirstName());
		speaker.setLast_name(sessionDomain.getSpeaker().getLastName());
		speaker.setCompany(sessionDomain.getSpeaker().getCompany());
		speaker.setTitle(sessionDomain.getSpeaker().getTitle());
		speaker.setSpeaker_bio(sessionDomain.getSpeaker().getBio());
		Speaker addedSpeaker = speakerRepository.saveAndFlush(speaker);

		SessionDomain addedSessionDomain = new SessionDomain();
		addedSessionDomain.setSessionId(addedSession.getSession_id().intValue());
		addedSessionDomain.setSessionName(addedSession.getSession_name());
		addedSessionDomain.setSessionDescription(addedSession.getSession_description());
		addedSessionDomain.setSessionLength(addedSession.getSession_length());

		SpeakerDomain addedSpeakerDomain = new SpeakerDomain();
		addedSpeakerDomain.setSpeakerId(addedSpeaker.getSpeaker_id().intValue());
		addedSpeakerDomain.setFirstName(addedSpeaker.getFirst_name());
		addedSpeakerDomain.setLastName(addedSpeaker.getLast_name());
		addedSpeakerDomain.setCompany(addedSpeaker.getCompany());
		addedSpeakerDomain.setTitle(addedSpeaker.getTitle());
		addedSpeakerDomain.setBio(addedSpeaker.getSpeaker_bio());

		SessionSpeakers sessionSpeakersList = new SessionSpeakers();
		sessionSpeakersList.setSession_id(addedSession.getSession_id().intValue());
		sessionSpeakersList.setSpeaker_id(addedSpeaker.getSpeaker_id().intValue());
		sessionSpeakersRepository.saveAndFlush(sessionSpeakersList);

		addedSessionDomain.setSpeaker(addedSpeakerDomain);
		return addedSessionDomain;

	}

	public SessionDomain putSession(SessionDomain sessionDomain) {

		Session session = new Session();
		session.setSession_id(Long.valueOf(sessionDomain.getSessionId()));
		session.setSession_name(sessionDomain.getSessionName());
		session.setSession_description(sessionDomain.getSessionDescription());
		session.setSession_length(sessionDomain.getSessionLength());
		Session addedSession = sessionRepository.saveAndFlush(session);
		Speaker speaker = new Speaker();
		speaker.setFirst_name(sessionDomain.getSpeaker().getFirstName());
		speaker.setSpeaker_id(Long.valueOf(sessionDomain.getSpeaker().getSpeakerId()));
		speaker.setLast_name(sessionDomain.getSpeaker().getLastName());
		speaker.setCompany(sessionDomain.getSpeaker().getCompany());
		speaker.setTitle(sessionDomain.getSpeaker().getTitle());
		speaker.setSpeaker_bio(sessionDomain.getSpeaker().getBio());
		Speaker addedSpeaker = speakerRepository.saveAndFlush(speaker);

		SessionDomain addedSessionDomain = new SessionDomain();
		addedSessionDomain.setSessionId(addedSession.getSession_id().intValue());
		addedSessionDomain.setSessionName(addedSession.getSession_name());
		addedSessionDomain.setSessionDescription(addedSession.getSession_description());
		addedSessionDomain.setSessionLength(addedSession.getSession_length());

		SpeakerDomain addedSpeakerDomain = new SpeakerDomain();
		addedSpeakerDomain.setSpeakerId(addedSpeaker.getSpeaker_id().intValue());
		addedSpeakerDomain.setFirstName(addedSpeaker.getFirst_name());
		addedSpeakerDomain.setLastName(addedSpeaker.getLast_name());
		addedSpeakerDomain.setCompany(addedSpeaker.getCompany());
		addedSpeakerDomain.setTitle(addedSpeaker.getTitle());
		addedSpeakerDomain.setBio(addedSpeaker.getSpeaker_bio());

		addedSessionDomain.setSpeaker(addedSpeakerDomain);
		return addedSessionDomain;

	}

	public UserData getListWithNames(Long id) {
		Session session = sessionRepository.getOne(id);
		UserData userData = new UserData();
		userData.setSessionName(session.getSession_name());

		SessionSpeakers sessionSpeaker = sessionSpeakersRepository.getOne(id.intValue());
		Speaker speaker = speakerRepository.getOne(Long.valueOf(sessionSpeaker.getSpeaker_id()));
		userData.setSpeakerName(speaker.getFirst_name() + " " + speaker.getLast_name());

		
		List<WorkshopDetails> workshopNamesList = new ArrayList<WorkshopDetails>();

		List<WorkshopSpeakers> workshopSpeakersList = workshopSpeakersRepository.findAll();


		for (WorkshopSpeakers workshopSpeakers : workshopSpeakersList) {
			
			if (speaker.getSpeaker_id() == workshopSpeakers.getSpeaker_id()) {
				Workshops workshop = workshopRepository.getOne(Long.valueOf(workshopSpeakers.getWorkshop_id()));
				WorkshopRegistration workshopRigistration = workshopRegistrationRepository.getOne(workshop.getWorkshop_id().intValue());
				AttendeeTickets attendeeTickets = attendeeTicketsRepository.getOne(Long.valueOf(workshopRigistration.getAttendee_ticket_id()));
				WorkshopDetails workshopDetails = new WorkshopDetails();
				workshopDetails.setWorkshopName(workshop.getWorkshop_name());
				workshopDetails.setAttendeeId(attendeeTickets.getAttendee_id());
				workshopNamesList.add(workshopDetails);
			}
		
		
		}
		userData.setWorkshopDetails(workshopNamesList);
		return userData;
	}

	public TreeSet<String> getSessionNames() {
		
		TreeSet<String> sessionNames = new TreeSet<String>();
		
		List<Session> sessionList = sessionRepository.findAll();
		for (Session session : sessionList) {
			
			sessionNames.add(session.getSession_name());
			
		}
		//Collections.sort(sessionNames);
		return sessionNames;
	}

	public List<Session> getCSVList() {
		String path = "/Users/sasidharkoduru/Downloads/test.csv";
		String line = "";
		List<Session> sessionList = new ArrayList<Session>();
		try {
			BufferedReader fileReader = new BufferedReader(new FileReader(path));
			
			
			int i =0;
			while((line = fileReader.readLine()) != null){
				if(i==0) {
					i++;
					continue;
				}
				
				String[] values = line.split(",");
			    Session session = new Session();
			    session.setSession_id(Long.parseLong(values[0]));
			    session.setSession_name(values[1]);
			    session.setSession_description(values[2]);
			    session.setSession_length(Integer.valueOf(values[3]));
			    sessionList.add(session);
			    }
			
		}
		 catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sessionList;
	}
	

	public List<Session> getXMLList() {
		
		try {
			File file = new File("/Users/sasidharkoduru/Downloads/test.csv.xml");
			DocumentBuilderFactory fact =DocumentBuilderFactory.newInstance();
			DocumentBuilder builder =fact.newDocumentBuilder();
			Document doc = builder.parse("/Users/sasidharkoduru/Downloads/test.csv.xml");
			doc.getDocumentElement().normalize();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}


