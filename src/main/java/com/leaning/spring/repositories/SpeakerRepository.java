package com.leaning.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leaning.spring.models.Speaker;


public interface SpeakerRepository extends JpaRepository<Speaker, Long>{

}
