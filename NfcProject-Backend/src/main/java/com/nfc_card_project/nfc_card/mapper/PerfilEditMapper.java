
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



//     @Mapping(expression = "java(monocard.getMonocardId())", target = "moncardId")
    //     // @Mapping(source = "name", target = "nome") apenas serve para fazer mapeamento dos campos que não são iguais
    // @Mapper(componentModel = "spring", imports = MonoCardService.class)