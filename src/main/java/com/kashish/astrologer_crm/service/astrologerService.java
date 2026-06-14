package com.kashish.astrologer_crm.service;

import com.kashish.astrologer_crm.dto.request.AstrologerRequestDto;
import com.kashish.astrologer_crm.dto.response.AstrologerResponseDto;
import com.kashish.astrologer_crm.entity.astrologer;
import com.kashish.astrologer_crm.repository.astrologerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class astrologerService {
    private final astrologerRepo repo;
    public List<AstrologerResponseDto> getAllAstrologers(){
        return repo.findAll()
                .stream()
                .map(astrologer -> AstrologerResponseDto.builder()
                        .id(astrologer.getId())
                        .name(astrologer.getName())
                        .specialization(astrologer.getSpecialization())
                        .experience_year(astrologer.getExperience_year())
                        .email(astrologer.getEmail())
                        .phone(astrologer.getPhone())
                        .status(astrologer.getStatus())
                        .build())
                .toList();
    }

    private AstrologerResponseDto mapToResponse(
            astrologer astrologer) {

        return AstrologerResponseDto.builder()
                .id(astrologer.getId())
                .name(astrologer.getName())
                .specialization(astrologer.getSpecialization())
                .experience_year(astrologer.getExperience_year())
                .email(astrologer.getEmail())
                .phone(astrologer.getPhone())
                .status(astrologer.getStatus())
                .build();
    }
    public AstrologerResponseDto createAstrologer(AstrologerRequestDto request){
        astrologer astro = astrologer.builder()
                .name(request.getName())
                .specialization(request.getSpecialization())
                .experience_year(request.getExperience_year())
                .email(request.getEmail())
                .phone(request.getPhone())
                .status(request.getStatus())
                .build();

        astrologer saved = repo.save(astro);

        return mapToResponse(saved);
    }

    public AstrologerResponseDto getAstrologerById(Long id){
        astrologer astro = repo.findById(id)
                .orElseThrow(()->new RuntimeException("Astrologer not found"));

        return mapToResponse(astro);
    }

    public AstrologerResponseDto updateAstrologer(Long id,AstrologerRequestDto request){
        astrologer astro = repo.findById(id)
                .orElseThrow(()->new RuntimeException("Astrologer not found"));

        astro.setName(request.getName());
        astro.setSpecialization(request.getSpecialization());
        astro.setExperience_year(request.getExperience_year());
        astro.setEmail(request.getEmail());
        astro.setPhone(request.getPhone());
        astro.setStatus(request.getStatus());

        astrologer updated = repo.save(astro);

        return mapToResponse(updated);
    }

    public void deleteAstrologer(Long id){
        if(!repo.existsById(id)){
            throw new RuntimeException("Astrologer Not found");

        }
        repo.deleteById(id);
    }
}
