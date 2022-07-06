package com.nfc_card_project.nfc_card.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nfc_card_project.nfc_card.domains.models.Card;
import com.nfc_card_project.nfc_card.domains.repositories.CardRepository;


@Service
public class CardService {

    @Autowired
    CardRepository cardRepository;

    public Card save(@Valid Card card) {
        return null;
    }

    public List<Card> findAll() {
        return null;
    }

    public Optional<Card> findByTitulo(String titulo) {
        return null;
    }

    public Optional<Card> findById(Long id) {
        return null;
    }

    public void delete(Card card) {
    }
    
}
