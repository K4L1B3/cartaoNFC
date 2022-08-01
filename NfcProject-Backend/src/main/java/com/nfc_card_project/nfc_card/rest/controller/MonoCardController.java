package com.nfc_card_project.nfc_card.rest.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nfc_card_project.nfc_card.domains.models.MonoCard;
import com.nfc_card_project.nfc_card.services.MonoCardService;

@RestController
@RequestMapping("/monocard")
public class MonoCardController {

    @Autowired
    private MonoCardService monoCardService;

    //Salvar/criar monocard
    @PostMapping("/create")
    public ResponseEntity<MonoCard> save(@RequestBody MonoCard monoCard ){
        return ResponseEntity.status(HttpStatus.CREATED).body(monoCardService.save(monoCard));
    }


    //Editar/atualizar monocard
    @PutMapping("/editMonoCard/{id}")
    public ResponseEntity<MonoCard> updateMonoCard(@PathVariable (value = "id") Long id, @RequestBody MonoCard monoCard) {

        MonoCard monoCardOptional = monoCardService.findById(id);

        var atualizarMonoCard = new MonoCard();
        BeanUtils.copyProperties(monoCard, atualizarMonoCard);
        monoCard.setId(monoCardOptional.getId());
        return ResponseEntity.status(HttpStatus.OK).body(monoCardService.save(atualizarMonoCard));

    }
    
    
    //Listar todos os monocards
    @GetMapping("/findAll")
    public List<MonoCard> findAllCards() {
        return monoCardService.findAll();
    }
}
