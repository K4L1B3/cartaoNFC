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
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "perfil")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    

    @Column
    private String nome;

    @Column
    private String bio;

    @Column
    private boolean tornarPerfilPrivado = false;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "monocardId", referencedColumnName = "id")
    private MonoCard monoCard;

    @OneToOne(mappedBy = "perfil")
    private Usuario usuario;
    
}
// //Pai
// @OneToOne(mappedBy = "address")
// private User user;

// //Filho - chave estrangeira
// @OneToOne(cascade = CascadeType.ALL)
// @JoinColumn(name = "address_id", referencedColumnName = "id")
// private Address address;
