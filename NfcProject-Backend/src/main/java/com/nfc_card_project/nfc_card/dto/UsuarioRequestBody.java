package com.nfc_card_project.nfc_card.dto;

import com.nfc_card_project.nfc_card.domains.models.Perfil;

import lombok.Builder;
import lombok.Data;

@Data
public class UsuarioRequestBody {
    
    private String email;

    private String password;

    private boolean admin = false;
    
    private Long perfilId;


}
