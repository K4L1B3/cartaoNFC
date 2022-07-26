package com.nfc_card_project.nfc_card.dto;
import lombok.Data;

@Data
public class UsuarioRequestBody {
    
    private String email;

    private String password;

    private boolean admin = false;
    
    private Long perfilId;


}
