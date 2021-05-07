package com.leaning.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leaning.spring.models.SessionSpeakers;




public interface SessionSpeakersRepository extends JpaRepository<SessionSpeakers, Integer>{

}
