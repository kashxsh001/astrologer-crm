package com.kashish.astrologer_crm.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AstrologerResponseDto {
    private Long id;
    private String name;
    private String specialization;
    private Integer experience_year;
    private String email;
    private String phone;
    private String status;
}
