package com.leaning.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leaning.spring.models.AttendeeTickets;

public interface AttendeeTicketsRepository extends JpaRepository< AttendeeTickets, Long >{

}
