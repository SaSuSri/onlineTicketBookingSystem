package com.sasusri.onlineTicketBookingSystem.dto;

import java.io.Serializable;

public class EventDto implements Serializable {
    
	private String title;
    private String location;
    
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

    
}
