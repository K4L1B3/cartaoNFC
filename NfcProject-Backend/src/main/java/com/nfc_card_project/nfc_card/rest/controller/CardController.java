package com.nfc_card_project.nfc_card.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nfc_card_project.nfc_card.domains.models.Card;
import com.nfc_card_project.nfc_card.services.CardService;

@RestController
@RequestMapping("/editCard")
public class CardController {
    

    @Autowired
    private CardService cardService;

    //Criar card
    @PostMapping("/create")
    public ResponseEntity<Object> save(@RequestBody Card card) {
        
        if (cardService.existsByTitulo(card.getTitulo()) && cardService.existsByLink(card.getLink())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Esse card já existe");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(cardService.save(card));            


    }

    //Listar todos os cards
    @GetMapping("/listAll")
    public List<Card> findAllCards() {
        return cardService.findAll();
    }

    //Pesquisar card por titulo
    @GetMapping("/findByTitle/{titulo}")
    public ResponseEntity<Object> findByTitle(@PathVariable (value = "titulo") String titulo) {

        
        Optional<Card> cardOptional = cardService.findByTitulo(titulo);
        
        if(!cardOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Por favor informe o titulo do card para realizar a pesquisa");
        } 
        
        return ResponseEntity.status(HttpStatus.OK).body(cardOptional.get());
 
    } 

    //Atualizar card
    @PutMapping("/edit/{id}")
    public ResponseEntity<Object> updateCard(@PathVariable (value = "id")Long id, @RequestBody Card card) {
        Optional<Card> cardOptional = cardService.findById(id);
        if(!cardOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
        }    
    
        var atualizarCard = new Card();
        BeanUtils.copyProperties(card, atualizarCard);
        card.setId(cardOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(cardService.save(atualizarCard));
    }

    //Deletar card
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Object> deleteCard(@PathVariable (value = "id") Long id) {
        Optional<Card> cardOptional = cardService.findById(id);
        if (!cardOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro: usuário náo encontrado");
        }

        cardService.delete(cardOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Card deletado com sucesso!");
    }


}
