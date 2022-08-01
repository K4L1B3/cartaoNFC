package com.nfc_card_project.nfc_card.dto;

import lombok.Data;

@Data
public class PerfilEditRequestBody {
    
    private Long id;

    private String nome;

    private String bio;

    private boolean tornarPerfilPrivado = false;

    private Long monocardId;

    private Long usuarioId;

}
