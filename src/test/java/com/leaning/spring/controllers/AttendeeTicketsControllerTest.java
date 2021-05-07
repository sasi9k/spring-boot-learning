package com.leaning.spring.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.PathVariable;

import com.leaning.spring.domain.AttendeeTicketsDomain;
import com.leaning.spring.services.AttendeeTicketsService;


@SpringBootTest
public class AttendeeTicketsControllerTest {
	
	@InjectMocks
	AttendeeTicketsController attendeeTicketsController;
	
	@Mock
	AttendeeTicketsService attendeeTicketsService;
	
	@Test
	public void getWorkshopsWithRegistration() {
		List<AttendeeTicketsDomain> attendeeTicketsListData = new ArrayList<AttendeeTicketsDomain>();
		Mockito.when(attendeeTicketsService.getWorkshopsWithRegistration()).thenReturn(attendeeTicketsListData);
		
		
		List<AttendeeTicketsDomain> attendeeTicketsList = attendeeTicketsController.listOfWorkshopsRegistration();
		
		assertEquals(attendeeTicketsListData,attendeeTicketsList);
	}
	
	@Test
	public void getWorkshopWithRegistration() {
		List<AttendeeTicketsDomain> attendeeTicketsListData = new ArrayList<AttendeeTicketsDomain>();
		Mockito.when(attendeeTicketsService.getWorkshopWithRegistration(Mockito.anyLong())).thenReturn(attendeeTicketsListData);
		
		List<AttendeeTicketsDomain> attendeeTicketsList = attendeeTicketsController.listWithWorkshopsRegistration(2L);
		assertEquals(attendeeTicketsListData,attendeeTicketsList);
	}
	
	@Test
	public void postListOfWorkshopsRegistration() {
		AttendeeTicketsDomain attendeeTicketDomain = new AttendeeTicketsDomain();
		Mockito.when(attendeeTicketsService.postListOfWorkshopsRegistration(Mockito.any(AttendeeTicketsDomain.class))).thenReturn(attendeeTicketDomain);
		
		AttendeeTicketsDomain createattendeeTicketDomain = new AttendeeTicketsDomain();
		createattendeeTicketDomain.setAttendeeTicketId(2l);
		AttendeeTicketsDomain attendeeTicket = attendeeTicketsController.create(createattendeeTicketDomain);
	
		assertEquals(attendeeTicketDomain, attendeeTicket);
	}
	

}

