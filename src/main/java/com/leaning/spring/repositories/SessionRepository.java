package com.leaning.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leaning.spring.models.Session;

public interface SessionRepository extends JpaRepository<Session, Long> {
	
	

}
