package com.nfc_card_project.nfc_card.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nfc_card_project.nfc_card.domains.models.MonoCard;
import com.nfc_card_project.nfc_card.domains.models.Perfil;
import com.nfc_card_project.nfc_card.domains.repositories.PerfilRepository;
import com.nfc_card_project.nfc_card.dto.PerfilSaveRequestBody;
import com.nfc_card_project.nfc_card.mapper.PerfilMapper;

@Service
public class PerfilService {

    @Autowired
    private MonoCardService monoCardService;

    @Autowired
    private PerfilRepository perfilRepository;

    public Perfil save(PerfilSaveRequestBody perfilRequestBodyDto) {
        MonoCard monoCard = monoCardService.findById(perfilRequestBodyDto.getMonoCardId());
        Perfil perfil = PerfilMapper.toPerfil(perfilRequestBodyDto, monoCardService);
        Perfil perfilSaved = perfilRepository.save(perfil);
        monoCard.setPerfil(perfilSaved);
        monoCardService.save(monoCard);
        return perfilSaved;
    }

    public boolean existsById(Long id) {
        return perfilRepository.existsById(id);
    }

    public Perfil findById(Long id) {
        return perfilRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Erro ao buscar id"));
    }
 

    public List<Perfil> findAll() {
        return perfilRepository.findAll();
    }
    
}
 
