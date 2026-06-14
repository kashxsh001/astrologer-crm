package com.kashish.astrologer_crm.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class astrologer extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    private String specialization;
    private Integer experience_year;
    @Column(unique = true)
    private String email;
    private String phone;
    private String status;

}
