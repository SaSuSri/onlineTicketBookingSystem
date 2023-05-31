package com.sasusri.onlineTicketBookingSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sasusri.onlineTicketBookingSystem.dto.BookingDto;
import com.sasusri.onlineTicketBookingSystem.exception.ResourceNotFoundException;
import com.sasusri.onlineTicketBookingSystem.model.Booking;
import com.sasusri.onlineTicketBookingSystem.model.User;
import com.sasusri.onlineTicketBookingSystem.repository.UserRepository;
import com.sasusri.onlineTicketBookingSystem.service.BookingService;


import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/{userId}")
    public Booking bookTicket(@PathVariable Long userId, @RequestBody Booking booking) {
        userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        return bookingService.bookTicket(userId, booking);
    }

    @GetMapping("/{userId}")
    public List<Booking> getBookingsByUser(@PathVariable Long userId) {
        userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        return bookingService.getBookingsByUser(userId);
    }
}