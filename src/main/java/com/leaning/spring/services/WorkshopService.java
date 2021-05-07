package com.leaning.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leaning.spring.domain.AttendeeTicketsDomain;
import com.leaning.spring.domain.SpeakerDomain;
import com.leaning.spring.domain.WorkshopDomain;
import com.leaning.spring.models.AttendeeTickets;
import com.leaning.spring.models.Speaker;
import com.leaning.spring.models.WorkshopRegistration;
import com.leaning.spring.models.WorkshopSpeakers;
import com.leaning.spring.models.Workshops;
import com.leaning.spring.repositories.AttendeeTicketsRepository;
import com.leaning.spring.repositories.SpeakerRepository;
import com.leaning.spring.repositories.WorkshopRegistrationRepository;
import com.leaning.spring.repositories.WorkshopRepository;
import com.leaning.spring.repositories.WorkshopSpeakersRepository;

@Service
public class WorkshopService {
	@Autowired
	private AttendeeTicketsRepository attendeeTicketsRepository;
	@Autowired
	private WorkshopRegistrationRepository workshopRegistrationRepository;
	@Autowired
	private WorkshopRepository workshopRepository;
	@Autowired
	private WorkshopSpeakersRepository workshopSpeakersRepository;
	@Autowired
	private SpeakerRepository speakersRepository;

public List<WorkshopDomain> getWorkshopsWithAttendee(){
	List<Workshops> workshopsList = workshopRepository.findAll();
	List<WorkshopRegistration> workshopRegistrationList = workshopRegistrationRepository.findAll();
	List<WorkshopDomain> workshopDomainList = new ArrayList<WorkshopDomain>();

	workshopsList.forEach((workshops) -> {
		WorkshopDomain workshopDomain = new WorkshopDomain();
		workshopDomain.setWorkshopId(workshops.getWorkshop_id());
		workshopDomain.setWorkshopName(workshops.getWorkshop_name());
		workshopDomain.setDescription(workshops.getDescription());
		workshopDomain.setRequirements(workshops.getRequirements());
		workshopDomain.setRoom(workshops.getRoom());
		workshopDomain.setCapacity(workshops.getCapacity());
		List<AttendeeTicketsDomain> attendeeTicketsDomainList = new ArrayList<AttendeeTicketsDomain>();
		
		workshopRegistrationList.forEach((workshopRegistration)-> {
			if (workshops.getWorkshop_id() == workshopRegistration.getWorkshop_id()) {
				AttendeeTickets attendeeTickets= attendeeTicketsRepository.getOne(Long.valueOf(workshopRegistration.getAttendee_ticket_id()));
				AttendeeTicketsDomain attendeeTicketsDomain = new AttendeeTicketsDomain();
				attendeeTicketsDomain.setAttendeeTicketId(attendeeTickets.getAttendee_ticket_id());
				attendeeTicketsDomain.setAttendeeId(attendeeTickets.getAttendee_id());
				attendeeTicketsDomain.setTicketPriceId(attendeeTickets.getTicket_price_id());
				attendeeTicketsDomain.setDiscountCodeId(attendeeTickets.getDiscount_code_id());
				attendeeTicketsDomain.setNetPrice(attendeeTickets.getNet_price());
				attendeeTicketsDomainList.add(attendeeTicketsDomain);
			}
		});
		workshopDomain.setAttendeeTickets(attendeeTicketsDomainList);
		workshopDomainList.add(workshopDomain);
		
	});
	return workshopDomainList;
}
	/*public List<WorkshopDomain> getWorkshops() {
		
		List<Workshops> workshopsList = workshopRepository.findAll();

		List<WorkshopDomain> workshopDomainList = new ArrayList<WorkshopDomain>();

		workshopsList.forEach((workshop) -> {
			if (workshop.getCapacity() >= 30) {
				WorkshopDomain workshopDomain = new WorkshopDomain();
				workshopDomain.setCapacity(workshop.getCapacity());
				workshopDomain.setDescription(workshop.getDescription());
				workshopDomain.setRoom(workshop.getRoom());
				workshopDomain.setWorkshopId(workshop.getWorkshop_id());
				workshopDomain.setWorkshopName(workshop.getWorkshop_name());
				workshopDomainList.add(workshopDomain);
			}
		});
		return workshopDomainList;

	}*/
	public List<WorkshopDomain> getWorkshops(){
		List<Workshops> workshopsList = workshopRepository.findAll();
		List<WorkshopSpeakers> workshopSpeakersList = workshopSpeakersRepository.findAll();
		List<WorkshopDomain> workshopDomainList = new ArrayList<WorkshopDomain>();
		
		
		workshopsList.forEach((workshops) -> {
			WorkshopDomain workshopDomain = new WorkshopDomain();
			workshopDomain.setWorkshopId(workshops.getWorkshop_id());
			workshopDomain.setWorkshopName(workshops.getWorkshop_name());
			workshopDomain.setDescription(workshops.getDescription());
			workshopDomain.setRoom(workshops.getRoom());
			workshopDomain.setRequirements(workshops.getRequirements());
			workshopDomain.setCapacity(workshops.getCapacity());
			List<SpeakerDomain> speakerDomainList = new ArrayList<SpeakerDomain>();
		
		workshopSpeakersList.forEach((workshopSpeakers) -> {
			if(workshops.getWorkshop_id() == workshopSpeakers.getWorkshop_id()) {
				Speaker speaker = speakersRepository.getOne(Long.valueOf(workshopSpeakers.getSpeaker_id()));
				SpeakerDomain speakerDomain = new SpeakerDomain();
				speakerDomain.setSpeakerId(speaker.getSpeaker_id().intValue());
				speakerDomain.setFirstName(speaker.getFirst_name());
				speakerDomain.setLastName(speaker.getLast_name());
				speakerDomain.setTitle(speaker.getTitle());
				speakerDomain.setCompany(speaker.getCompany());
				speakerDomainList.add(speakerDomain);
			}
		});
		workshopDomain.setSpeakers(speakerDomainList);
		workshopDomainList.add(workshopDomain);
		});
		/*for(Workshops workshops : workshopsList) {
			WorkshopDomain workshopDomain = new WorkshopDomain();
			workshopDomain.setWorkshopId(workshops.getWorkshop_id());
			workshopDomain.setWorkshopName(workshops.getWorkshop_name());
			workshopDomain.setDescription(workshops.getDescription());
			workshopDomain.setRoom(workshops.getRoom());
			workshopDomain.setRequirements(workshops.getRequirements());
			workshopDomain.setCapacity(workshops.getCapacity());
			List<SpeakerDomain> speakerDomainList = new ArrayList<SpeakerDomain>();
				for(WorkshopSpeakers workshopSpeakers : workshopSpeakersList) {
				if(workshops.getWorkshop_id() == workshopSpeakers.getWorkshop_id()) {
					Speaker speaker = speakersRepository.getOne(Long.valueOf(workshopSpeakers.getSpeaker_id()));
					SpeakerDomain speakerDomain = new SpeakerDomain();
					speakerDomain.setSpeakerId(speaker.getSpeaker_id().intValue());
					speakerDomain.setFirstName(speaker.getFirst_name());
					speakerDomain.setLastName(speaker.getLast_name());
					speakerDomain.setTitle(speaker.getTitle());
					speakerDomain.setCompany(speaker.getCompany());
					speakerDomainList.add(speakerDomain);
				}
			}
			workshopDomain.setSpeakers(speakerDomainList);
			workshopDomainList.add(workshopDomain);
		}*/
		
		return workshopDomainList;
	}
	public WorkshopDomain postWorkshop(WorkshopDomain workshopDomain) {
		
		Workshops workshops = new Workshops();
		workshops.setWorkshop_name(workshopDomain.getWorkshopName());
		workshops.setDescription(workshopDomain.getDescription());
		workshops.setCapacity(workshopDomain.getCapacity());
		workshops.setRequirements(workshopDomain.getRequirements());
		workshops.setRoom(workshopDomain.getRoom());
		Workshops addedWorkshop =workshopRepository.saveAndFlush(workshops);
		
		AttendeeTickets attendeeTickets = new AttendeeTickets();
		attendeeTickets.setAttendee_id(workshopDomain.getAttendeeTickets().get(0).getAttendeeId());
		attendeeTickets.setDiscount_code_id(workshopDomain.getAttendeeTickets().get(0).getDiscountCodeId());
		attendeeTickets.setTicket_price_id(workshopDomain.getAttendeeTickets().get(0).getTicketPriceId());
		attendeeTickets.setNet_price(workshopDomain.getAttendeeTickets().get(0).getNetPrice());
		AttendeeTickets addedAttendeeTickets = attendeeTicketsRepository.saveAndFlush(attendeeTickets);
		
		WorkshopDomain addedWorkshopDomain = new WorkshopDomain();
		addedWorkshopDomain.setWorkshopId(addedWorkshop.getWorkshop_id());
		addedWorkshopDomain.setWorkshopName(addedWorkshop.getWorkshop_name());
		addedWorkshopDomain.setDescription(addedWorkshop.getDescription());
		addedWorkshopDomain.setCapacity(addedWorkshop.getCapacity());
		addedWorkshopDomain.setRequirements(addedWorkshop.getRequirements());
		addedWorkshopDomain.setRoom(addedWorkshop.getRoom());
		
		List<AttendeeTicketsDomain> attendeeTicketsDomainList = new ArrayList<AttendeeTicketsDomain>();
		AttendeeTicketsDomain addedAttendeeTicketsDomain = new AttendeeTicketsDomain();
		addedAttendeeTicketsDomain.setAttendeeTicketId(addedAttendeeTickets.getAttendee_ticket_id());
		addedAttendeeTicketsDomain.setAttendeeId(addedAttendeeTickets.getAttendee_id());
		addedAttendeeTicketsDomain.setDiscountCodeId(addedAttendeeTickets.getDiscount_code_id());
		addedAttendeeTicketsDomain.setTicketPriceId(addedAttendeeTickets.getTicket_price_id());
		addedAttendeeTicketsDomain.setNetPrice(addedAttendeeTickets.getNet_price());
		
		WorkshopRegistration workshopRegistration = new WorkshopRegistration();
		workshopRegistration.setAttendee_ticket_id((int) attendeeTickets.getAttendee_ticket_id());
		workshopRegistration.setWorkshop_id(workshops.getWorkshop_id().intValue());
		workshopRegistrationRepository.saveAndFlush(workshopRegistration);
		
		attendeeTicketsDomainList.add(addedAttendeeTicketsDomain);
		addedWorkshopDomain.setAttendeeTickets(attendeeTicketsDomainList);
		
		return addedWorkshopDomain;
	}

}
