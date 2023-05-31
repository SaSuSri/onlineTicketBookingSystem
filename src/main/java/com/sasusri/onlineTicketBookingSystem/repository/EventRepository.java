package com.sasusri.onlineTicketBookingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sasusri.onlineTicketBookingSystem.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {}