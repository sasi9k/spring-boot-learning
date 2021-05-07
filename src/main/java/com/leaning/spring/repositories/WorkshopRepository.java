package com.leaning.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leaning.spring.models.Workshops;

public interface WorkshopRepository extends JpaRepository<Workshops, Long> {

}
