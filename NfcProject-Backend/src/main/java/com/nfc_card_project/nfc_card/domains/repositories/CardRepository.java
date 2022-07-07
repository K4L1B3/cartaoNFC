package com.nfc_card_project.nfc_card.domains.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nfc_card_project.nfc_card.domains.models.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Long>{

    Optional<Card> findByTitulo(String titulo);
    
}
