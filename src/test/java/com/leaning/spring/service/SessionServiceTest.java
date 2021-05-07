package com.leaning.spring.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.leaning.spring.domain.SessionDomain;
import com.leaning.spring.domain.SpeakerDomain;
import com.leaning.spring.models.Session;
import com.leaning.spring.models.SessionSpeakers;
import com.leaning.spring.models.Speaker;
import com.leaning.spring.repositories.SessionRepository;
import com.leaning.spring.repositories.SessionSpeakersRepository;
import com.leaning.spring.repositories.SpeakerRepository;
import com.leaning.spring.services.SessionService;

@SpringBootTest
public class SessionServiceTest {
	
	@InjectMocks
	SessionService sessionService;
	
	@Mock
	SessionRepository sessionRepository;
	
	@Mock
	SessionSpeakersRepository sessionSpeakersRepository;
	
	@Mock
	SpeakerRepository speakerRepository;
	
	@Test
	public void getSessionsTest(){
		
		List<SessionSpeakers> sessionSpeakersList = new ArrayList<SessionSpeakers>();
		SessionSpeakers sessionSpeaker = new SessionSpeakers();
		sessionSpeaker.setSession_id(2);
		sessionSpeaker.setSpeaker_id(4);
		sessionSpeakersList.add(sessionSpeaker);
		Mockito.when(sessionSpeakersRepository.findAll()).thenReturn(sessionSpeakersList);
		
		List<Session> sessionList = new ArrayList<Session>();
		Session session = new Session();
		session.setSession_id(Long.valueOf(2));
		session.setSession_name("sai");
		session.setSession_description("java");
		session.setSession_length(3);
		sessionList.add(session);
		Mockito.when(sessionRepository.findAll()).thenReturn(sessionList);
		
		
		Speaker speaker = new Speaker();
		speaker.setSpeaker_id(Long.valueOf(4));
		speaker.setFirst_name("king");
		speaker.setLast_name("kong");
		speaker.setTitle("forest");
		speaker.setCompany("");
		Mockito.when(speakerRepository.getOne(Long.valueOf(sessionSpeaker.getSpeaker_id()))).thenReturn(speaker);
		
		
		List<SessionDomain> sessionDomainList = new ArrayList<SessionDomain>();
		SessionDomain sessionDomain = new SessionDomain();
		sessionDomain.setSessionId(session.getSession_id().intValue());
		sessionDomain.setSessionName(session.getSession_name());
		sessionDomain.setSessionDescription(session.getSession_description());
		sessionDomain.setSessionLength(session.getSession_length());
		
		
		SpeakerDomain speakerDomain = new SpeakerDomain();
		speakerDomain.setSpeakerId(speaker.getSpeaker_id().intValue());
		speakerDomain.setFirstName(speaker.getFirst_name());
		speakerDomain.setLastName(speaker.getLast_name());
		speakerDomain.setTitle(speaker.getTitle());
		speakerDomain.setCompany(speaker.getCompany());
		sessionDomain.setSpeaker(speakerDomain);
		sessionDomainList.add(sessionDomain);

		
		List<SessionDomain> getSessionDomainList = sessionService.getSessions();
		
		
		assertEquals(sessionDomainList.get(0).getSessionId() ,getSessionDomainList.get(0).getSessionId());
	}
	
	@Test
	public void postSessionTest() {
		Session addedSession = new Session();
		addedSession.setSession_id(Long.valueOf(4));
		addedSession.setSession_name("sai");
		addedSession.setSession_description("Java Programming");
		addedSession.setSession_length(40);
		Mockito.when(sessionRepository.saveAndFlush(Mockito.any(Session.class))).thenReturn(addedSession);
		
		Speaker addedSpeaker = new Speaker();
		addedSpeaker.setSpeaker_id(Long.valueOf(1));
		addedSpeaker.setFirst_name("King");
		addedSpeaker.setLast_name("Kong");
		addedSpeaker.setCompany("Forst World");
		addedSpeaker.setTitle("Forest");
		addedSpeaker.setSpeaker_bio(" ");
		Mockito.when(speakerRepository.saveAndFlush(Mockito.any(Speaker.class))).thenReturn(addedSpeaker);
		
		SessionSpeakers sessionSpeakersList = new SessionSpeakers();
		sessionSpeakersList.setSession_id(4);
		sessionSpeakersList.setSpeaker_id(1);
		Mockito.when(sessionSpeakersRepository.saveAndFlush(Mockito.any(SessionSpeakers.class))).thenReturn(sessionSpeakersList);
	
		
		
		
		SessionDomain addedSessionDomain = new SessionDomain();
		addedSessionDomain.setSessionId(sessionSpeakersList.getSession_id());
		addedSessionDomain.setSessionName(addedSession.getSession_name());
		addedSessionDomain.setSessionDescription(addedSession.getSession_description());
		addedSessionDomain.setSessionLength(addedSession.getSession_length());

		SpeakerDomain addedSpeakerDomain = new SpeakerDomain();
		addedSpeakerDomain.setSpeakerId(		sessionSpeakersList.getSpeaker_id());
		addedSpeakerDomain.setFirstName(		addedSpeaker.getFirst_name());
		addedSpeakerDomain.setLastName(		addedSpeaker.getLast_name());
		addedSpeakerDomain.setCompany(		addedSpeaker.getCompany());
		addedSpeakerDomain.setTitle(	addedSpeaker.getTitle());
		addedSpeakerDomain.setBio(		addedSpeaker.getSpeaker_bio());
		
		addedSessionDomain.setSpeaker(addedSpeakerDomain);
		
		
		
		SessionDomain sessionDomain = new SessionDomain();
		sessionDomain.setSessionName("sai");
		sessionDomain.setSessionDescription("Java Programming");
		sessionDomain.setSessionLength(40);
		SpeakerDomain addedSpeaker2 = new SpeakerDomain();
		addedSpeaker2.setFirstName("King");
		addedSpeaker2.setLastName("Kong");
		addedSpeaker2.setCompany("Forst World");
		addedSpeaker2.setTitle("Forest");
		
		sessionDomain.setSpeaker(addedSpeaker2);
	
		
		SessionDomain postsessionDomain = sessionService.postSession(sessionDomain);
		assertEquals(addedSessionDomain.getSessionId() ,postsessionDomain.getSessionId());
		
	}
	
	@Test
	public void putSessionTest() {
		Session session = new Session();
		session.setSession_id(Long.valueOf(1));
		session.setSession_name("Sai");
		session.setSession_description("Java Learning");
		session.setSession_length(4);
		Mockito.when(sessionRepository.saveAndFlush(Mockito.any(Session.class))).thenReturn(session);
		
		Speaker speaker = new Speaker();
		speaker.setFirst_name("king");
		speaker.setSpeaker_id(Long.valueOf(40));
		speaker.setLast_name("Kong");
		speaker.setCompany("Forest World");
		speaker.setTitle("Forest");
		speaker.setSpeaker_bio("");
		Mockito.when(speakerRepository.saveAndFlush(Mockito.any(Speaker.class))).thenReturn(speaker);
		
		SessionDomain addedSessionDomain = new SessionDomain();
		addedSessionDomain.setSessionId(session.getSession_id().intValue());
		addedSessionDomain.setSessionName(session.getSession_name());
		addedSessionDomain.setSessionDescription(session.getSession_description());
		addedSessionDomain.setSessionLength(session.getSession_length());

		SpeakerDomain addedSpeakerDomain = new SpeakerDomain();
		addedSpeakerDomain.setSpeakerId(speaker.getSpeaker_id().intValue());
		addedSpeakerDomain.setFirstName(speaker.getFirst_name());
		addedSpeakerDomain.setLastName(speaker.getLast_name());
		addedSpeakerDomain.setCompany(speaker.getCompany());
		addedSpeakerDomain.setTitle(speaker.getTitle());
		addedSpeakerDomain.setBio(speaker.getSpeaker_bio());

		addedSessionDomain.setSpeaker(addedSpeakerDomain);
		
		SessionDomain sessionDomain = new SessionDomain();
		sessionDomain.setSessionId(1);
		sessionDomain.setSessionDescription("Java Learning");
		sessionDomain.setSessionLength(4);
		sessionDomain.setSessionName("Sai");
		
		SpeakerDomain speakerDomain = new SpeakerDomain();
		speakerDomain.setSpeakerId(40);
		speakerDomain.setFirstName("king");
		speakerDomain.setLastName("Kong");
		speakerDomain.setCompany("Forest World");
		speakerDomain.setTitle("Forest");
		speakerDomain.setBio("");
		sessionDomain.setSpeaker(speakerDomain);
		SessionDomain putSessionDomain = sessionService.putSession(sessionDomain);
		
		assertEquals(addedSessionDomain.getSessionId() ,putSessionDomain.getSessionId());
	}
}


