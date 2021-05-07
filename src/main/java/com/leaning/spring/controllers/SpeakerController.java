package com.leaning.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leaning.spring.domain.SpeakerDomain;
import com.leaning.spring.models.Speaker;
import com.leaning.spring.repositories.SpeakerRepository;
import com.leaning.spring.services.SpeakerService;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakerController {
	@Autowired
	private SpeakerRepository speakerRipository;
	
	@Autowired
	private SpeakerService speakerService;
	
//	@GetMapping
//	public List<Speaker> list() {
//		return speakerRipository.findAll();
//
//	}
	
	@GetMapping
	public List<SpeakerDomain> getAllSpeakers(){
		return speakerService.getSpeakers();
	}
	
	@GetMapping
	@RequestMapping("/{id}")
	public Speaker get(@PathVariable Long id) {
		return speakerRipository.getOne(id);
		
	}
	
	@PostMapping
	public SpeakerDomain create(@RequestBody SpeakerDomain speakerDomain) {
		return speakerService.postSpeaker(speakerDomain);
	}
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		
		speakerRipository.deleteById(id);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public SpeakerDomain update(@RequestBody SpeakerDomain speakerDomain) {
		
		return speakerService.putSpeaker(speakerDomain);
	}

}
