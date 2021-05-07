package com.leaning.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leaning.spring.models.WorkshopRegistration;

public interface WorkshopRegistrationRepository extends JpaRepository<WorkshopRegistration, Integer>{

}
