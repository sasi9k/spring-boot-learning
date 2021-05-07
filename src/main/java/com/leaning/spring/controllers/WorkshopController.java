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

import com.leaning.spring.domain.WorkshopDomain;
import com.leaning.spring.models.Workshops;
import com.leaning.spring.repositories.WorkshopRepository;
import com.leaning.spring.services.WorkshopService;



@RestController
@RequestMapping("/api/v1/workshops")
public class WorkshopController {
	@Autowired
	private WorkshopRepository workshopRepository;
	@Autowired
	private WorkshopService workshopService;

	@GetMapping
	public List<WorkshopDomain> list() {
		return workshopService.getWorkshops();
	}
	@GetMapping
	@RequestMapping("/attendeetickets")
	public List<WorkshopDomain> workshopList() {
		return workshopService.getWorkshopsWithAttendee();
	}
	
	@GetMapping
	@RequestMapping(value = "/{id}")
	public Workshops get(@PathVariable Long id) {
		return workshopRepository.getOne(id);

	}

	@PostMapping
	public Workshops create(@RequestBody Workshops workshops) {
		return workshopRepository.saveAndFlush(workshops);
	}
	@PostMapping
	@RequestMapping("domain")
	public WorkshopDomain create(@RequestBody WorkshopDomain workshopDomain) {
		return workshopService.postWorkshop(workshopDomain);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		workshopRepository.deleteById(id);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public Workshops update(@RequestBody Workshops workshops) {
		return workshopRepository.saveAndFlush(workshops);
	}

}
