package com.kashish.astrologer_crm.dto.request;

import com.kashish.astrologer_crm.enums.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ClientRequestDto {
    @NotBlank(message = "Name is required")
    private String name;
    @Email(message = "Invalid email")
    private String email;
    @Pattern(
            regexp = "^[0-9]{10}$",
            message = "Phone number must contain exactly 10 digits"
    )
    private String phone;
    private LocalDate birthDate;
    private Gender gender;
}
