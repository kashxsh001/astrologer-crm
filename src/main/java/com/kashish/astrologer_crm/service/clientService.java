package com.kashish.astrologer_crm.service;

import com.kashish.astrologer_crm.dto.request.ClientRequestDto;
import com.kashish.astrologer_crm.dto.response.ClientResponseDto;
import com.kashish.astrologer_crm.entity.Client;
import com.kashish.astrologer_crm.exception.ResourceNotFoundException;
import com.kashish.astrologer_crm.repository.clientRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class clientService {
    private final clientRepo repo;

    private ClientResponseDto maptoResponse(Client client){
        return ClientResponseDto.builder()
                .id(client.getId())
                .name(client.getName())
                .email(client.getEmail())
                .phone(client.getPhone())
                .birthDate(client.getBirthDate())
                .gender(client.getGender())
                .build();
    }

    public List<ClientResponseDto> getAllClient(){
        return repo.findAll()
                .stream()
                .map(client->maptoResponse(client))
                .toList();
    }

    public ClientResponseDto createClient(ClientRequestDto req){
        Client client = Client.builder()
                .name(req.getName())
                .email(req.getEmail())
                .phone(req.getPhone())
                .birthDate(req.getBirthDate())
                .gender(req.getGender())
                .build();

        Client saved = repo.save(client);
        return maptoResponse(saved);
    }

    public ClientResponseDto getClientById(Long id){
        Client client = repo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Client not found"));
         return maptoResponse(client);
    }

    public ClientResponseDto updateClient(Long id, ClientRequestDto request){
        Client client = repo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Client not Found with id: "+id));

        client.setName(request.getName());
        client.setEmail(request.getEmail());
        client.setPhone(request.getPhone());
        client.setBirthDate(request.getBirthDate());
        client.setGender(request.getGender());

        Client updated = repo.save(client);

        return maptoResponse(updated);

    }

    public void DeleteClient(Long id){
        if(repo.existsById(id)){
            repo.deleteById(id);
        }else{
            throw new ResourceNotFoundException("Client not exists");
        }
    }


}
