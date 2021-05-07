package com.leaning.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leaning.spring.models.TimeSlots;

public interface TimeSlotsRepository extends JpaRepository<TimeSlots, Long>{

}
