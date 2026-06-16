package com.kashish.astrologer_crm.service;

import com.kashish.astrologer_crm.dto.request.AppointmentRequestDto;
import com.kashish.astrologer_crm.dto.response.AppointmentResponseDto;
import com.kashish.astrologer_crm.entity.Appointment;
import com.kashish.astrologer_crm.entity.Client;
import com.kashish.astrologer_crm.entity.Status;
import com.kashish.astrologer_crm.entity.astrologer;
import com.kashish.astrologer_crm.exception.ResourceNotFoundException;
import com.kashish.astrologer_crm.repository.AppointmentRepo;
import com.kashish.astrologer_crm.repository.astrologerRepo;
import com.kashish.astrologer_crm.repository.clientRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepo repo;
    private final clientRepo cRepo;
    private final astrologerRepo aRepo;
    private AppointmentResponseDto mapToResponse(Appointment appo){
        return AppointmentResponseDto.builder()
                .id(appo.getId())
                .client_id(appo.getClient().getId())
                .client_name(appo.getClient().getName())
                .astrologer_id(appo.getAstrologer().getId())
                .astrologer_name(appo.getAstrologer().getName())
                .appointment_time(appo.getAppointmentTime())
                .status(appo.getStatus())
                .build();

    }

    public List<AppointmentResponseDto> getAllAppointments(){
        return repo.findAll()
                .stream()
                .map(appointment->mapToResponse(appointment))
                .toList();
    }

    public AppointmentResponseDto createAppointment(AppointmentRequestDto req){
        Client client = cRepo.findById(req.getClient_id())
                .orElseThrow(()->new ResourceNotFoundException("Client Not found with id: "+ req.getClient_id()));

        astrologer  astro = aRepo.findById(req.getAstrologer_id())
                .orElseThrow(()->new RuntimeException("Astrologer not found with id: "+ req.getAstrologer_id()));
        Appointment app = Appointment.builder()
                .client(client)
                .astrologer(astro)
                .appointmentTime(req.getAppointment_time())
                .status(Status.PENDING)
                .build();

        Appointment saved = repo.save(app);
        return mapToResponse(saved);

    }

    public AppointmentResponseDto getAppointmentById(Long id){
        Appointment app = repo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Appointment not found"));

        return mapToResponse(app);

    }

    public AppointmentResponseDto updateAppointment(Long id,AppointmentRequestDto req){
        Appointment app = repo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Appointment Not found"));

        Client client = cRepo.findById(req.getClient_id())
                .orElseThrow(()->new ResourceNotFoundException("Client not found"));

        astrologer astro = aRepo.findById(req.getAstrologer_id())
                .orElseThrow(()->new ResourceNotFoundException("Astrologer not found"));

        app.setClient(client);
        app.setAstrologer(astro);
        app.setAppointmentTime(req.getAppointment_time());
         Appointment updated = repo.save(app);
         return mapToResponse(updated);
    }

    public void deleteAppointment(Long id){
        Appointment app = repo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Appointment not found with id: "+id));

        repo.delete(app);
    }

    public AppointmentResponseDto updateStatus(Long id, Status status){
        Appointment app = repo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Appointment not found"));

        app.setStatus(status);
        Appointment updated = repo.save(app);
        return mapToResponse(updated);
    }
}
