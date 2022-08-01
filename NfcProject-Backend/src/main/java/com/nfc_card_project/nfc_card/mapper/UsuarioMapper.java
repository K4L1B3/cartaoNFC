package com.nfc_card_project.nfc_card.mapper;

import com.nfc_card_project.nfc_card.domains.models.Usuario;
import com.nfc_card_project.nfc_card.dto.UsuarioSaveRequestBody;
import com.nfc_card_project.nfc_card.services.PerfilService;

public class UsuarioMapper {
    
    public static Usuario toUsuario(UsuarioSaveRequestBody usuarioSaveRequestBody, PerfilService perfilService) {
        
        return Usuario.builder()
        .email(usuarioSaveRequestBody.getEmail())
        .password(usuarioSaveRequestBody.getPassword())
        .admin(usuarioSaveRequestBody.isAdmin())
        .perfil(perfilService.findById(usuarioSaveRequestBody.getPerfilId()))
        .build();
    }

}
