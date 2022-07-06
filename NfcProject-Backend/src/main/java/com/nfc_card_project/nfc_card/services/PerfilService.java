package com.nfc_card_project.nfc_card.services;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nfc_card_project.nfc_card.domains.models.Perfil;
import com.nfc_card_project.nfc_card.domains.repositories.PerfilRepository;

@Service
public class PerfilService {


    @Autowired
    PerfilRepository perfilRepository;

    public Object save(@Valid Perfil perfil) {
        return perfilRepository.save(perfil);
    }

    public boolean existsById(Long id) {
        return perfilRepository.existsById(id);
    }

    public Optional<Perfil> findById(Long id) {
        return perfilRepository.findById(id);
    }
    
}
 
