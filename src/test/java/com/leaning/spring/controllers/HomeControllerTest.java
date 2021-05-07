package com.leaning.spring.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class HomeControllerTest {
	
	@InjectMocks
	private HomeController homeController;
	
	@Test
	public void getVersionTest() {
		Map<String, Integer> versionData = homeController.getVersion(20,40);
		
		
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("app-version", 60);
		
		
		
		assertEquals(map, versionData);

	}

}
