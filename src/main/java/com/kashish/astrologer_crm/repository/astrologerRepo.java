package com.kashish.astrologer_crm.repository;

import com.kashish.astrologer_crm.entity.astrologer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface astrologerRepo extends JpaRepository<astrologer,Long> {
}
