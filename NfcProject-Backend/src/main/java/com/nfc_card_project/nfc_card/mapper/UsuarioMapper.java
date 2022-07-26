package com.nfc_card_project.nfc_card.mapper;

import com.nfc_card_project.nfc_card.domains.models.Usuario;
import com.nfc_card_project.nfc_card.dto.UsuarioRequestBody;
import com.nfc_card_project.nfc_card.services.PerfilService;

public class UsuarioMapper {
    
    public static Usuario toUsuario(UsuarioRequestBody usuarioRequestBody, PerfilService perfilService) {
        
        return Usuario.builder()
        .email(usuarioRequestBody.getEmail())
        .password(usuarioRequestBody.getPassword())
        .admin(usuarioRequestBody.isAdmin())
        .perfil(perfilService.findById(usuarioRequestBody.getPerfilId()))
        .build();
    }

}
