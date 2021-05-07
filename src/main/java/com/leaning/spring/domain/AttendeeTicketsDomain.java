package com.leaning.spring.domain;

public class AttendeeTicketsDomain {
	private long attendeeTicketId;
	private int attendeeId;
	private int ticketPriceId;
	private int discountCodeId;
	private float netPrice;
	private Long workshopId;
	private String workshopName;
	private String description;
	private String requirements;
	private String room;
	private int capacity;
	
	public Long getWorkshopId() {
		return workshopId;
	}
	public void setWorkshopId(Long workshopId) {
		this.workshopId = workshopId;
	}
	public String getWorkshopName() {
		return workshopName;
	}
	public void setWorkshopName(String workshopName) {
		this.workshopName = workshopName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRequirements() {
		return requirements;
	}
	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public long getAttendeeTicketId() {
		return attendeeTicketId;
	}
	public void setAttendeeTicketId(long attendeeTicketId) {
		this.attendeeTicketId = attendeeTicketId;
	}
	public int getAttendeeId() {
		return attendeeId;
	}
	public void setAttendeeId(int attendeeId) {
		this.attendeeId = attendeeId;
	}
	public int getTicketPriceId() {
		return ticketPriceId;
	}
	public void setTicketPriceId(int ticketPriceId) {
		this.ticketPriceId = ticketPriceId;
	}
	public int getDiscountCodeId() {
		return discountCodeId;
	}
	public void setDiscountCodeId(int discountCodeId) {
		this.discountCodeId = discountCodeId;
	}
	public float getNetPrice() {
		return netPrice;
	}
	public void setNetPrice(float netPrice) {
		this.netPrice = netPrice;
	}

}
