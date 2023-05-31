package com.sasusri.onlineTicketBookingSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sasusri.onlineTicketBookingSystem.model.Event;
import com.sasusri.onlineTicketBookingSystem.repository.EventRepository;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }
    
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event getEventById(Long id) {
        return eventRepository.findById(id).orElse(null);
    }
    
    public Event updateEvent(Long id, Event newEvent) {
        return eventRepository.findById(id).map(event -> {
            event.setName(newEvent.getName());
            event.setEventDate(newEvent.getEventDate());
            event.setLocation(newEvent.getLocation());
            return eventRepository.save(event);
        }).orElseGet(() -> {
            newEvent.setId(id);
            return eventRepository.save(newEvent);
        });
    }
    
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
}
