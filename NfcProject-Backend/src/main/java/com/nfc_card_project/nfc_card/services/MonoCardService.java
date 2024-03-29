package com.nfc_card_project.nfc_card.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nfc_card_project.nfc_card.domains.models.MonoCard;
import com.nfc_card_project.nfc_card.domains.repositories.MonoCardRepository;

@Service
public class MonoCardService {
    

    @Autowired
    MonoCardRepository monoCardRepository;

    public MonoCard save(MonoCard monoCard) {
        return monoCardRepository.save(monoCard);
    }

    public MonoCard findById(Long id) {
        return monoCardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Erro ao buscar id"));
    }
    
  

    public List<MonoCard> findAll() {
        return monoCardRepository.findAll();
    }


}
