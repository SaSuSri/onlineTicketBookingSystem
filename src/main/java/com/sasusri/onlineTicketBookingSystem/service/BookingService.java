package com.sasusri.onlineTicketBookingSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sasusri.onlineTicketBookingSystem.exception.ResourceNotFoundException;
import com.sasusri.onlineTicketBookingSystem.model.Booking;
import com.sasusri.onlineTicketBookingSystem.model.User;
import com.sasusri.onlineTicketBookingSystem.repository.BookingRepository;
import com.sasusri.onlineTicketBookingSystem.repository.UserRepository;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

    public Booking bookTicket(Long userId, Booking booking) {
        return userRepository.findById(userId).map(user -> {
            booking.setUser(user);
            return bookingRepository.save(booking);
        }).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
    }

    public List<Booking> getBookingsByUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        return bookingRepository.findByUser(user);
    }
}