package com.leaning.spring.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.leaning.spring.models.TimeSlots;
import com.leaning.spring.repositories.TimeSlotsRepository;

@SpringBootTest
public class TimeSlotsControllerTest {
	@InjectMocks
	TimeSlotsController timeSlotsController;
	@Mock
	TimeSlotsRepository timeSlotsRepository;
	@Test
	public void findAll() {
		List<TimeSlots> timeSlotsList = new ArrayList<TimeSlots>();
		Mockito.when(timeSlotsRepository.findAll()).thenReturn(timeSlotsList);
		
		List<TimeSlots> timeSlots = timeSlotsController.list();
		assertEquals(timeSlotsList, timeSlots);
		
	}

}
