package com.nfc_card_project.nfc_card.dto;

import lombok.Data;

@Data
public class PerfilSaveRequestBody {

    private String nome;

    private String bio;

    private boolean tornarPerfilPrivado = false;

    private Long monoCardId;

    private Long usuarioId;

}


