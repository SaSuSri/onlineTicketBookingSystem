package com.sasusri.onlineTicketBookingSystem.dto;

import java.io.Serializable;

public class BookingDto implements Serializable {
    private Long userId;
    private Long eventId;
    
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getEventId() {
		return eventId;
	}
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}
    
}
