package com.kashish.astrologer_crm.dto.response;

import com.kashish.astrologer_crm.enums.Gender;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ClientResponseDto {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private LocalDate birthDate;
    private Gender gender;
}
