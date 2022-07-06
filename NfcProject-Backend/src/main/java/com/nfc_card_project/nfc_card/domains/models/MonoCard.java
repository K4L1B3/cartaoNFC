package com.nfc_card_project.nfc_card.domains.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MonoCard")
public class MonoCard {
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @ElementCollection
    private List<Card> card = new ArrayList<Card>();
    
    @Column
    private String corDoMonoPrimaria;
    
    @Column
    private String corDoMonoSecundaria;
    
    @Column
    private String corDoMonoTercearea;
    
    @Column
    private String corDoMonoQuaternaria;

    
}
