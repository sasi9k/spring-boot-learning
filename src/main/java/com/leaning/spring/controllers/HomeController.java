package com.leaning.spring.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/")
public class HomeController {
	
//	@Value("${app.version}")
//	private String appVersion;
	
	@GetMapping
	public Map<String, Integer> getVersion(int a, int b) {
	
		int c = a+b;
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("app-version", c);
		return map;
		
	}

}
