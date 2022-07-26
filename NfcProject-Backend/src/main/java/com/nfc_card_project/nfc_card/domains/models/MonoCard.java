package com.nfc_card_project.nfc_card.domains.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "monocard")
public class MonoCard {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Referenciando o ID do filho
    @ElementCollection
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "monoCard")
    private List<Card> cardList = new ArrayList<Card>();
    
    @Column
    private String corDoMonoPrimaria;
    
    @Column
    private String corDoMonoSecundaria;
    
    @Column
    private String corDoMonoTercearia;
    
    @Column
    private String corDoMonoQuaternaria;

    @OneToOne(mappedBy = "monoCard")
    private Perfil perfil;
}
