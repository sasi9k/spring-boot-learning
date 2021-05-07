package com.leaning.spring.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leaning.spring.domain.SessionDomain;
import com.leaning.spring.domain.SpeakerDomain;
import com.leaning.spring.models.UserData;
import com.leaning.spring.models.Session;
import com.leaning.spring.repositories.SessionRepository;
import com.leaning.spring.services.SessionService;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionController {
	@Autowired
	private SessionRepository sessionRepository;
	
	@Autowired
	private SessionService sessionService;
	
//	@GetMapping
//	public List<Session> list() {
//		return sessionRepository.findAll();
//		
//	}
	
	@GetMapping
	public List<SessionDomain> getAllSessions(){
		return sessionService.getSessions();
	}
	
	@GetMapping
	@RequestMapping(value="/{id}")
	public Session get(@PathVariable Long id) {
		return sessionRepository.getOne(id);
		
	}
	@GetMapping
	@RequestMapping(value="/speakerWorkshop/{id}")
	public UserData getNamesList(@PathVariable Long id) {
		return sessionService.getListWithNames(id);
	}
	@PostMapping
	public SessionDomain create(@RequestBody SessionDomain sessionDomain) {
		return sessionService.postSession(sessionDomain);
	}
	
//	@PostMapping
//	public Session create(@RequestBody Session session) {
//		return sessionRepository.saveAndFlush(session);
//	}
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		
		 sessionRepository.deleteById(id);
	}
	
	@RequestMapping( method=RequestMethod.PUT)
	public SessionDomain update(@RequestBody SessionDomain sessionDomain) {
		
		return sessionService.putSession(sessionDomain);
	}

}
