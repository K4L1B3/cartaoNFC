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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Perfil")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    

    @Column
    private String nome;

    @Column
    private String bio;

    @Column
    @Builder.Default
    private boolean tornarPerfilPrivado = false;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "monoCard_id", referencedColumnName = "id")
    @JsonManagedReference(value="monocard-reference")
    private MonoCard monoCard;
    
    @OneToOne(mappedBy = "perfil")
    @JsonBackReference(value="usuario-reference")
    private Usuario usuario;

    public boolean isPresent() {
        return false;
    }
    
}
// //Pai
// @OneToOne(mappedBy = "address")
// private User user;

// //Filho - chave estrangeira
// @OneToOne(cascade = CascadeType.ALL)
// @JoinColumn(name = "address_id", referencedColumnName = "id")
// private Address address;
