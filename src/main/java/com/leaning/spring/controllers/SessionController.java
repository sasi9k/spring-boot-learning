package com.leaning.spring.controllers;

import java.util.List;
import java.util.TreeSet;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	@RequestMapping("/names")
	public TreeSet<String> getAllSessionNames(){
		return sessionService.getSessionNames();
	}
	
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
	
	
//	@GetMapping
//	@RequestMapping("/unique")
//	public List<Session> getUniqueSessions(){
//		return sessionRepository.findDistinctAllSessionName();
//	}
	
	@GetMapping
	@RequestMapping(value="/byNames")
	public List<Session> getSessionsByName(@RequestParam String name) {
		return sessionRepository.findBySessionName(name);
		
	}
	@GetMapping
	@RequestMapping(value="/byLength")
	public List<Session> getSessionsByLength(@RequestParam int sessionLength){
		return sessionRepository.findBySessionLengthOrderBySessionNameAsc(sessionLength);
	}
	
	@GetMapping
	@RequestMapping(value = "/byNameOrLength")
	public List<Session> getSessionsByNameOrLength(@RequestParam String name,@RequestParam int sessionLength){
		return sessionRepository.findBySessionNameOrSessionLength(name,sessionLength);
	}
	
	@GetMapping
	@RequestMapping(value="/byLengthBetween")
	public List<Session> getSessionsByLengthBetween(@RequestParam int sessionLength, @RequestParam int sessionLength1){
		return sessionRepository.findBySessionLengthBetween(sessionLength, sessionLength1);
	}
	
	@GetMapping
	@RequestMapping(value="/byLengthLessThan")
	public List<Session> getSessionsByLengthLessThan(@RequestParam int sessionLength){
		return sessionRepository.findBySessionLengthLessThan(sessionLength);
	}
	@GetMapping
	@RequestMapping(value="/byLengthLessThanEqual")
	public List<Session> getSessionsByLengthLessThanEqual(@RequestParam int sessionLength){
		return sessionRepository.findBySessionLengthLessThanEqual(sessionLength);
	}
	@GetMapping
	@RequestMapping(value="/byLengthAfter")
	public List<Session> getSessionsLengthAfter(@RequestParam int sessionLength){
		return sessionRepository.findBySessionLengthAfter(sessionLength);
	}
	
	@GetMapping
	@RequestMapping(value="/byLengthNotNull")
	public List<Session> getSessionsLengthNotNull(){
		return sessionRepository.findBySessionLengthIsNotNull();
	}

	@GetMapping
	@RequestMapping(value="/byNamesLike")
	public List<Session> getSessionsByNameLike(@RequestParam String name) {
		name = "%"+ name +"%";
		return sessionRepository.findBySessionNameLike(name);
		
	}
	
	@GetMapping
	@RequestMapping(value="/byLengthNull")
	public List<Session> getSessionsLengthNull(){
		return sessionRepository.findBySessionLengthIsNull();
	}
	
	@GetMapping
	@RequestMapping(value="/byNamesStarting")
	public List<Session> getSessionsByNameStartingWith(@RequestParam String name) {
		return sessionRepository.findBySessionNameStartingWith(name);
		
	}

//	@GetMapping
//	@RequestMapping(value="/byNamesNotStarting")
//	public List<Session> getSessionsByNameStartingWith(@RequestParam String name) {
//		return sessionRepository.findBySessionNameStartingWith(name);
//		
//	}
	
	@GetMapping
	@RequestMapping("/CSVList")
	public List<Session> getSessionCSVList(){
		return sessionService.getCSVList();
	}
}

