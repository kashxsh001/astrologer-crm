package com.kashish.astrologer_crm.dto.request;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class AppointmentRequestDto {
    private long client_id;
    private long astrologer_id;
    private LocalDateTime appointment_time;
}
