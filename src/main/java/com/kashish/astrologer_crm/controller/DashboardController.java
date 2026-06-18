package com.kashish.astrologer_crm.controller;

import com.kashish.astrologer_crm.dto.response.DashboardResponseDto;
import com.kashish.astrologer_crm.service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/dashboard")
public class DashboardController {
    private final DashboardService service;
    @GetMapping
    public ResponseEntity<DashboardResponseDto> getDashboardStats(){
        return ResponseEntity.ok(service.getDashboardStats());
    }
}
