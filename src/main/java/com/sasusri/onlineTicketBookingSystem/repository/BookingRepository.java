package com.sasusri.onlineTicketBookingSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sasusri.onlineTicketBookingSystem.model.Booking;
import com.sasusri.onlineTicketBookingSystem.model.User;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
	List<Booking> findByUser(User user);
}
