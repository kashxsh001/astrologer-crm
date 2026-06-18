package com.kashish.astrologer_crm.service;

import com.kashish.astrologer_crm.dto.response.DashboardResponseDto;
import com.kashish.astrologer_crm.enums.Status;
import com.kashish.astrologer_crm.repository.AppointmentRepo;
import com.kashish.astrologer_crm.repository.astrologerRepo;
import com.kashish.astrologer_crm.repository.clientRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DashboardService {
    private final astrologerRepo aRepo;
    private final clientRepo cRepo;
    private final AppointmentRepo repo;

    public DashboardResponseDto getDashboardStats(){
        return DashboardResponseDto.builder()
        .totalAstrologers(aRepo.count())
                .totalClients(cRepo.count())
                .totalAppointments(repo.count())
                .pendingAppointments(repo.countByStatus(Status.PENDING))
                .completedAppointments(repo.countByStatus(Status.DONE))
                .cancelledAppointments(repo.countByStatus(Status.CANCELLED))
                .build();
    }
}
