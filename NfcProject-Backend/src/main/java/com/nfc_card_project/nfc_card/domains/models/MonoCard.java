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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "MonoCard")
@JsonIdentityInfo(
    generator = ObjectIdGenerators.PropertyGenerator.class,
    property = "id",
    scope = Long.class
)
public class MonoCard {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Referenciando o ID do filho
    @Builder.Default
    @ElementCollection
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "monoCard")
    @JsonManagedReference(value="card-reference")
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
    @JsonBackReference(value="monocard-reference")
    private Perfil perfil;
}
