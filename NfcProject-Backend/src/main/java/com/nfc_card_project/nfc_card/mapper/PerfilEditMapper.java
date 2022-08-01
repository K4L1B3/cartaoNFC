package com.nfc_card_project.nfc_card.mapper;

import com.nfc_card_project.nfc_card.domains.models.Perfil;
import com.nfc_card_project.nfc_card.dto.PerfilEditRequestBody;
import com.nfc_card_project.nfc_card.services.MonoCardService;

public class PerfilEditMapper {
    
    public static Perfil toPerfil(PerfilEditRequestBody perfilEditRequestBody, MonoCardService monocardService) {
        
        return Perfil.builder()
        .id(perfilEditRequestBody.getId())
        .nome(perfilEditRequestBody.getNome())
        .bio(perfilEditRequestBody.getBio())
        .tornarPerfilPrivado(perfilEditRequestBody.isTornarPerfilPrivado())
        .monoCard(monocardService.findById(perfilEditRequestBody.getMonocardId()))
        .build();
    }

}
