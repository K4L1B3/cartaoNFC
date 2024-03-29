package com.nfc_card_project.nfc_card.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nfc_card_project.nfc_card.domains.models.Card;
import com.nfc_card_project.nfc_card.domains.repositories.CardRepository;


@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    public Card save(Card card) {
        return cardRepository.save(card);
    }

    public List<Card> findAll() {
       return cardRepository.findAll();
    }

    public Optional<Card> findByTitulo(String titulo) {
        return cardRepository.findByTitulo(titulo);
    }

    public Optional<Card> findById(Long id) {
        return cardRepository.findById(id);
    }

    public void delete(Card card) {
        cardRepository.delete(card);
    }

    public boolean existsByTitulo(String titulo) {
        return cardRepository.existsByTitulo(titulo);
    }

    public boolean existsByLink(String link) {
        return cardRepository.existsByLink(link);
    }
    
}