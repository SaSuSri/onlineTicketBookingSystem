package com.sasusri.onlineTicketBookingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sasusri.onlineTicketBookingSystem.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}

