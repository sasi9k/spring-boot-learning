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

import com.leaning.spring.models.Speaker;
import com.leaning.spring.repositories.SpeakerRepository;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakerController {
	@Autowired
	private SpeakerRepository speakerRipository;
	
	@GetMapping
	public List<Speaker> list() {
		return speakerRipository.findAll();
		
	}
	
	@GetMapping
	@RequestMapping("/{id}")
	public Speaker get(@PathVariable Long id) {
		return speakerRipository.getOne(id);
		
	}
	
	@PostMapping
	public Speaker create(@RequestBody Speaker speaker) {
		return speakerRipository.saveAndFlush(speaker);
	}
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		
		speakerRipository.deleteById(id);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public Speaker update(@PathVariable Long id, @RequestBody Speaker speaker) {
		
		Speaker existingSpeaker = speakerRipository.getOne(id);
		BeanUtils.copyProperties(speaker, existingSpeaker, "session_id");
		return speakerRipository.saveAndFlush(existingSpeaker);
		
	}

}
