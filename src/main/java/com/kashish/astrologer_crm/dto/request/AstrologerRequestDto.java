package com.kashish.astrologer_crm.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AstrologerRequestDto {
    @NotBlank(message = "Name is required")
    private String name;
    private String specialization;
    private Integer experience_year;
    @Email(message = "Invalid Email format")
    private String email;

    private String phone;
    private String status;
}
