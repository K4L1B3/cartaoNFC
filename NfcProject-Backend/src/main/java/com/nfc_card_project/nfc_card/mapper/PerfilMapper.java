package com.nfc_card_project.nfc_card.mapper;

import com.nfc_card_project.nfc_card.domains.models.Perfil;
import com.nfc_card_project.nfc_card.dto.PerfilSaveRequestBody;
import com.nfc_card_project.nfc_card.services.MonoCardService;

public class PerfilMapper {
    
    public static Perfil toPerfil(PerfilSaveRequestBody perfilRequestBodyDto, MonoCardService  monoCardService) {
        
        return Perfil.builder()
        .nome(perfilRequestBodyDto.getNome())
        .bio(perfilRequestBodyDto.getBio())
        .tornarPerfilPrivado(perfilRequestBodyDto.isTornarPerfilPrivado())
        .monoCard(monoCardService.findById(perfilRequestBodyDto.getMonoCardId()))        
        .build();


    }

}
