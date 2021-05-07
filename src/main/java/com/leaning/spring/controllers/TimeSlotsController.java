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

import com.leaning.spring.models.TimeSlots;
import com.leaning.spring.repositories.TimeSlotsRepository;

@RestController
@RequestMapping("/api/v1/time_slots")
public class TimeSlotsController {
	@Autowired
	private TimeSlotsRepository timeSlotsRepository;

	@GetMapping
	public List<TimeSlots> list() {
		return timeSlotsRepository.findAll();
	}

	@GetMapping
	@RequestMapping(value = "/{id}")
	public TimeSlots get(@PathVariable Long id) {
		return timeSlotsRepository.getOne(id);
	}
	
	@PostMapping
	public TimeSlots Create(@RequestBody TimeSlots timeSlots) {
		return timeSlotsRepository.saveAndFlush(timeSlots);
		
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		timeSlotsRepository.deleteById(id);
	}
	@RequestMapping(method = RequestMethod.PUT)
	public TimeSlots update(@RequestBody TimeSlots timeSlots) {
		return timeSlotsRepository.saveAndFlush(timeSlots);
	}

}
