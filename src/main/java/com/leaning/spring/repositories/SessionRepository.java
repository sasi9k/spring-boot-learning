package com.leaning.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leaning.spring.models.Session;

public interface SessionRepository extends JpaRepository<Session, Long> {
	
	public List<Session> findBySessionName(String sessionName);
	public List<Session> findBySessionLengthOrderBySessionNameAsc(int sessionLength);
	public List<Session> findBySessionNameAndSessionLength(String sessionName, int sessionLength);
	public List<Session> findBySessionNameOrSessionLength(String sessionName, int sessionLength);
	public List<Session> findBySessionLengthBetween(int sessionLength, int sessionLength1);
	public List<Session> findBySessionLengthLessThan(int sessionLength);
	public List<Session> findBySessionLengthLessThanEqual(int sessionLength);
	public List<Session> findBySessionLengthAfter(int sessionLength);
	public List<Session> findBySessionLengthIsNotNull();
	public List<Session> findBySessionNameLike(String sessionName);
	public List<Session> findBySessionLengthIsNull();
	public List<Session> findBySessionNameStartingWith(String name);
}
