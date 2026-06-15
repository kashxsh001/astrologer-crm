package com.kashish.astrologer_crm.controller;

import com.kashish.astrologer_crm.dto.request.ClientRequestDto;
import com.kashish.astrologer_crm.dto.response.ClientResponseDto;
import com.kashish.astrologer_crm.service.clientService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/client")
@Tag(name="Client Api", description = "Manage Client")
public class ClientController {
    private final clientService service;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ClientResponseDto> getAllClient(){
        return service.getAllClient();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientResponseDto createClient(@Valid @RequestBody ClientRequestDto req){
        return service.createClient(req);
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClientResponseDto getClientById(@PathVariable Long id){
        return service.getClientById(id);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClientResponseDto updateClient(@PathVariable Long id, @Valid @RequestBody ClientRequestDto req){
        return service.updateClient(id,req);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String DeleteClientById(@PathVariable Long id){
        service.getClientById(id);
        return "Client Deleted";
    }


}

