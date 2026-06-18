package com.kashish.astrologer_crm.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DashboardResponseDto {
    private long totalAstrologers;
    private long totalClients;
    private long totalAppointments;

    private long pendingAppointments;

    private long completedAppointments;

    private long cancelledAppointments;
}
