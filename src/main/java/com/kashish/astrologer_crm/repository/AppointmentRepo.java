package com.kashish.astrologer_crm.repository;

import com.kashish.astrologer_crm.entity.Appointment;
import com.kashish.astrologer_crm.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment,Long> {
    long countByStatus(Status status);
}
