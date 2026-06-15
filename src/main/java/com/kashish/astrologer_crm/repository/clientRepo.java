package com.kashish.astrologer_crm.repository;

import com.kashish.astrologer_crm.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface clientRepo extends JpaRepository<Client,Long> {
}
