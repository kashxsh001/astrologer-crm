package com.kashish.astrologer_crm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Appointment extends BaseEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name="client_id")
    @ManyToOne
    private Client client;

    @ManyToOne
    @JoinColumn(name = "astrologer_id")
    private astrologer astrologer;

    private LocalDateTime appointmentTime;

    @Enumerated(EnumType.STRING)
    private Status status;

}
