package com.leaning.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leaning.spring.domain.AttendeeTicketsDomain;
import com.leaning.spring.repositories.AttendeeTicketsRepository;
import com.leaning.spring.services.AttendeeTicketsService;

@RestController
@RequestMapping("/api/v1/attendee_tickets")
public class AttendeeTicketsController {
	@Autowired
	private AttendeeTicketsRepository attendeeTicketsRepository;
	@Autowired
	private AttendeeTicketsService attendeeTicketsService;
	
	@GetMapping
	public List<AttendeeTicketsDomain> listOfWorkshopsRegistration(){
		return attendeeTicketsService.getWorkshopsWithRegistration();
	}
	@GetMapping
	@RequestMapping(value = "/{id}")
	public List<AttendeeTicketsDomain> listWithWorkshopsRegistration(@PathVariable Long id){
		return attendeeTicketsService.getWorkshopWithRegistration(id);
	}
	@PostMapping
	public AttendeeTicketsDomain create(@RequestBody AttendeeTicketsDomain attendeeTicketsDomain) {
		return attendeeTicketsService.postListOfWorkshopsRegistration(attendeeTicketsDomain);
	}
}
