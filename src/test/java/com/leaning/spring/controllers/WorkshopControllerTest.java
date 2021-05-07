package com.leaning.spring.controllers;



import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.leaning.spring.domain.WorkshopDomain;
import com.leaning.spring.models.Workshops;
import com.leaning.spring.repositories.WorkshopRepository;
import com.leaning.spring.services.WorkshopService;

@SpringBootTest
public class WorkshopControllerTest {
	
	@InjectMocks
	WorkshopController workshopController;
	
	@Mock
	WorkshopService workshopService;
	
	@Mock
	WorkshopRepository workshopRepository;
	
	@Test
	public void getWorkshops() {
		List<WorkshopDomain> workshopsList = new ArrayList<WorkshopDomain>();
		Mockito.when(workshopService.getWorkshops()).thenReturn(workshopsList);
		
		List<WorkshopDomain> workshopDomainList = workshopController.list();
		 
		assertEquals(workshopsList, workshopDomainList);
		
	}
	@Test
	public void getWorkshopsWithAttendee() {
		List<WorkshopDomain> workshopsList = new ArrayList<WorkshopDomain>();
		Mockito.when(workshopService.getWorkshopsWithAttendee()).thenReturn(workshopsList);
		
		List<WorkshopDomain> workshopDomainList = workshopController.workshopList();
		
		assertEquals(workshopsList, workshopDomainList);
	}
	@Test
	public void getOne() {
		Workshops workshop = new Workshops();
		Mockito.when(workshopRepository.getOne(Mockito.anyLong())).thenReturn(workshop);
		
		Workshops workshopWithId = workshopController.get(2L);
		assertEquals(workshop, workshopWithId);
	}
	@Test
	public void  createTest() {
		Workshops workshop = new Workshops();
		Mockito.when(workshopRepository.saveAndFlush(Mockito.any(Workshops.class))).thenReturn(workshop);
		
		Workshops newWorkshop = new Workshops();
		Workshops postWorkshop = workshopController.create(newWorkshop);
		
		assertEquals(workshop,postWorkshop);
	}

	@Test
	public void deleteTest() {
		
		 
		workshopController.delete(2L);
		Mockito.verify(workshopRepository).deleteById(Mockito.any());
		
	}
}


