package com.kashish.astrologer_crm.controller;

import com.kashish.astrologer_crm.dto.request.AppointmentRequestDto;
import com.kashish.astrologer_crm.dto.response.AppointmentResponseDto;
import com.kashish.astrologer_crm.entity.Status;
import com.kashish.astrologer_crm.service.AppointmentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name="Appointment Apis" , description="Manage Appointments")
@RequestMapping("/api/appointment")
public class AppointmentController {
    private final AppointmentService service;
    @GetMapping
    public ResponseEntity<List<AppointmentResponseDto>> getAllAppointments(){
        return ResponseEntity.ok(service.getAllAppointments());
    }
    @PostMapping
    public ResponseEntity<AppointmentResponseDto> createAppointment(@RequestBody @Valid AppointmentRequestDto req){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createAppointment(req));

    }
    @GetMapping("/{id}")
    public ResponseEntity<AppointmentResponseDto> getAppointmentById(@PathVariable Long id){
        return ResponseEntity.ok(service.getAppointmentById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<AppointmentResponseDto> updateAppointment(@PathVariable Long id, @Valid @RequestBody AppointmentRequestDto req){
        return ResponseEntity.ok(service.updateAppointment(id,req));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id){
            service.deleteAppointment(id);
            return ResponseEntity.noContent().build();
    }
    @PatchMapping("/{id}/status")
    public ResponseEntity<AppointmentResponseDto> updateStatus(@PathVariable Long id, @RequestParam Status status){
        return ResponseEntity.ok(service.updateStatus(id,status));
    }

}
