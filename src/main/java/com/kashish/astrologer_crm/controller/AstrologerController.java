package com.kashish.astrologer_crm.controller;

import com.kashish.astrologer_crm.dto.request.AstrologerRequestDto;
import com.kashish.astrologer_crm.dto.response.AstrologerResponseDto;
import com.kashish.astrologer_crm.service.astrologerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/astrologers")
@Tag(name = "Astrologer APIs",
        description = "Manage astrologers")
public class AstrologerController {
    private final astrologerService service;

    @GetMapping
    @Operation(summary = "Get all astrologers")
    public List<AstrologerResponseDto> getAllAstrologers(){
        return service.getAllAstrologers();
    }
@PostMapping
@Operation(summary = "Create astrologer")
@ResponseStatus(HttpStatus.CREATED)
    public AstrologerResponseDto createAstrologer(@Valid @RequestBody AstrologerRequestDto request){
        return service.createAstrologer(request);
    }
    @GetMapping("/{id}")
    public AstrologerResponseDto getAstrologerById(@PathVariable Long id){
        return service.getAstrologerById(id);
    }

    @PutMapping("/{id}")
    public AstrologerResponseDto updateAstrologer(@PathVariable Long id,@Valid @RequestBody AstrologerRequestDto request){
        return service.updateAstrologer(id,request);
    }
      @DeleteMapping("/{id}")
      @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteAstrologer(@PathVariable Long id){
        service.deleteAstrologer(id);
        return "Astrologer Deleted Successfully";
    }
}
