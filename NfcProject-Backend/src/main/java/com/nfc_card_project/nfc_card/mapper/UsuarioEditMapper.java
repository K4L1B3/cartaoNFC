package com.nfc_card_project.nfc_card.mapper;

import com.nfc_card_project.nfc_card.domains.models.Usuario;
import com.nfc_card_project.nfc_card.dto.UsuarioEditRequestBody;
import com.nfc_card_project.nfc_card.services.PerfilService;

public class UsuarioEditMapper {
    
    public static Usuario toUsuario(UsuarioEditRequestBody usuarioEditRequestBody, PerfilService perfilService) {

        return Usuario.builder()
                .id(usuarioEditRequestBody.getId())
                .email(usuarioEditRequestBody.getEmail())
                .password(usuarioEditRequestBody.getPassword())
                .admin(usuarioEditRequestBody.isAdmin())
                .perfil(perfilService.findById(usuarioEditRequestBody.getPerfilId()))       
                .build();
    }


}
