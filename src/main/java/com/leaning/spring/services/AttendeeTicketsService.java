package com.leaning.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leaning.spring.domain.AttendeeTicketsDomain;
import com.leaning.spring.models.AttendeeTickets;
import com.leaning.spring.models.WorkshopRegistration;
import com.leaning.spring.models.Workshops;
import com.leaning.spring.repositories.AttendeeTicketsRepository;
import com.leaning.spring.repositories.WorkshopRegistrationRepository;
import com.leaning.spring.repositories.WorkshopRepository;

@Service
public class AttendeeTicketsService {
	@Autowired
	private AttendeeTicketsRepository attendeeTicketsRepository;
	@Autowired
	private WorkshopRepository workshopRepository;
	@Autowired
	private WorkshopRegistrationRepository workshopRegistrationRepository;

	public List<AttendeeTicketsDomain> getWorkshopsWithRegistration() {
		List<AttendeeTickets> attendeeTicketsList = attendeeTicketsRepository.findAll();
		
		List<AttendeeTicketsDomain> attendeeTicketsDomainList = new ArrayList<AttendeeTicketsDomain>();
		for (AttendeeTickets attendeeTickets : attendeeTicketsList) {
			AttendeeTicketsDomain attendeeTicketsDomain = new AttendeeTicketsDomain();
			attendeeTicketsDomain.setAttendeeTicketId(attendeeTickets.getAttendee_ticket_id());
			attendeeTicketsDomain.setAttendeeId(attendeeTickets.getAttendee_id());
			attendeeTicketsDomain.setNetPrice(attendeeTickets.getNet_price());
			attendeeTicketsDomain.setDiscountCodeId(attendeeTickets.getDiscount_code_id());
			attendeeTicketsDomain.setTicketPriceId(attendeeTickets.getTicket_price_id());
			WorkshopRegistration workshopRegistration = workshopRegistrationRepository.getOne((int)attendeeTickets.getAttendee_ticket_id());
			
			Workshops workshops = workshopRepository.getOne(Long.valueOf(workshopRegistration.getWorkshop_id()));
			attendeeTicketsDomain.setWorkshopId(workshops.getWorkshop_id());
			attendeeTicketsDomain.setCapacity(workshops.getCapacity());
			attendeeTicketsDomain.setDescription(workshops.getDescription());
			attendeeTicketsDomain.setRequirements(workshops.getRequirements());
			attendeeTicketsDomain.setRoom(workshops.getRoom());
			attendeeTicketsDomain.setWorkshopName(workshops.getWorkshop_name());
				
				
			
			attendeeTicketsDomainList.add(attendeeTicketsDomain);
		}
		return attendeeTicketsDomainList;
	}

	public List<AttendeeTicketsDomain> getWorkshopWithRegistration(Long id) {
		
		
		List<WorkshopRegistration> workshopRegistrationList = workshopRegistrationRepository.findAll();
		List<AttendeeTicketsDomain> attendeeTicketsDomainList = new ArrayList<AttendeeTicketsDomain>();
		
			AttendeeTickets attendeeTickets = attendeeTicketsRepository.getOne(id);
			AttendeeTicketsDomain attendeeTicketsDomain = new AttendeeTicketsDomain();
			attendeeTicketsDomain.setAttendeeTicketId(attendeeTickets.getAttendee_ticket_id());
			attendeeTicketsDomain.setAttendeeId(attendeeTickets.getAttendee_id());
			attendeeTicketsDomain.setNetPrice(attendeeTickets.getNet_price());
			attendeeTicketsDomain.setDiscountCodeId(attendeeTickets.getDiscount_code_id());
			attendeeTicketsDomain.setTicketPriceId(attendeeTickets.getTicket_price_id());
			for (WorkshopRegistration workshopRegistration : workshopRegistrationList ) {
				if(workshopRegistration.getAttendee_ticket_id() == attendeeTickets.getAttendee_ticket_id()) {
				Workshops workshops = workshopRepository.getOne(Long.valueOf(workshopRegistration.getWorkshop_id()));
				attendeeTicketsDomain.setWorkshopId(workshops.getWorkshop_id());
				attendeeTicketsDomain.setCapacity(workshops.getCapacity());
				attendeeTicketsDomain.setDescription(workshops.getDescription());
				attendeeTicketsDomain.setRequirements(workshops.getRequirements());
				attendeeTicketsDomain.setRoom(workshops.getRoom());
				attendeeTicketsDomain.setWorkshopName(workshops.getWorkshop_name());
				}
				
			}
			attendeeTicketsDomainList.add(attendeeTicketsDomain);
		
		return attendeeTicketsDomainList;
	}



	public AttendeeTicketsDomain postListOfWorkshopsRegistration(AttendeeTicketsDomain attendeeTicketsDomain) {
		AttendeeTickets attendeeTickets = new AttendeeTickets();
		attendeeTickets.setAttendee_id(attendeeTicketsDomain.getAttendeeId());
		attendeeTickets.setDiscount_code_id(attendeeTicketsDomain.getDiscountCodeId());
		attendeeTickets.setNet_price(attendeeTicketsDomain.getNetPrice());
		attendeeTickets.setTicket_price_id(attendeeTicketsDomain.getTicketPriceId());
		AttendeeTickets addedattendeeTickets = attendeeTicketsRepository.saveAndFlush(attendeeTickets);
		
		Workshops workshops = new Workshops();
		
		workshops.setWorkshop_name(attendeeTicketsDomain.getWorkshopName());
		workshops.setDescription(attendeeTicketsDomain.getDescription());
		workshops.setCapacity(attendeeTicketsDomain.getCapacity());
		workshops.setRequirements(attendeeTicketsDomain.getRequirements());
		workshops.setRoom(attendeeTicketsDomain.getRoom());
		Workshops addedworkshops = workshopRepository.saveAndFlush(workshops);
		
		AttendeeTicketsDomain addedAttendeeTicketsDomain = new AttendeeTicketsDomain();
		addedAttendeeTicketsDomain.setAttendeeId(addedattendeeTickets.getAttendee_id());
		addedAttendeeTicketsDomain.setAttendeeTicketId(addedattendeeTickets.getAttendee_ticket_id());
		addedAttendeeTicketsDomain.setDiscountCodeId(addedattendeeTickets.getDiscount_code_id());
		addedAttendeeTicketsDomain.setNetPrice(addedattendeeTickets.getNet_price());
		addedAttendeeTicketsDomain.setTicketPriceId(addedattendeeTickets.getTicket_price_id());
		addedAttendeeTicketsDomain.setWorkshopId(addedworkshops.getWorkshop_id());
		addedAttendeeTicketsDomain.setCapacity(addedworkshops.getCapacity());
		addedAttendeeTicketsDomain.setDescription(addedworkshops.getDescription());
		addedAttendeeTicketsDomain.setRequirements(addedworkshops.getRequirements());
		addedAttendeeTicketsDomain.setWorkshopName(addedworkshops.getWorkshop_name());
		addedAttendeeTicketsDomain.setRoom(addedworkshops.getRoom());
		
		WorkshopRegistration workshopRegistration = new WorkshopRegistration();
		workshopRegistration.setAttendee_ticket_id((int) attendeeTickets.getAttendee_ticket_id());
		workshopRegistration.setWorkshop_id(workshops.getWorkshop_id().intValue());
		workshopRegistrationRepository.saveAndFlush(workshopRegistration);
		
		return addedAttendeeTicketsDomain;
	}
}

