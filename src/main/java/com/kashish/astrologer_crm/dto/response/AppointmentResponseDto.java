package com.kashish.astrologer_crm.dto.response;

import com.kashish.astrologer_crm.entity.Status;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Builder
public class AppointmentResponseDto {
    private Long id;
    private Long client_id;
    private String client_name;
    private Long astrologer_id;
    private String astrologer_name;
    private LocalDateTime appointment_time;
    private Status status;
}
