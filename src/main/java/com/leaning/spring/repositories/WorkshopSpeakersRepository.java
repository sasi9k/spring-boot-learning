package com.leaning.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leaning.spring.models.WorkshopSpeakers;

public interface WorkshopSpeakersRepository extends JpaRepository< WorkshopSpeakers, Integer> {

}
