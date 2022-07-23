package com.nfc_card_project.nfc_card.domains.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Perfil")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String nome;

    @Column
    private String bio;

    @Column
    private boolean tornarPerfilPrivado;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "perfilId")
    private MonoCard monoCard;

    @OneToOne
    @JoinColumn(nullable = false, name = "usuarioId")
    private Usuario usuarioId;
    
}
