package com.nfc_card_project.nfc_card.domains.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nfc_card_project.nfc_card.domains.models.MonoCardEdit;

@Repository
public interface MonoCardEditRepository extends JpaRepository<MonoCardEdit, Long>{
    
}
