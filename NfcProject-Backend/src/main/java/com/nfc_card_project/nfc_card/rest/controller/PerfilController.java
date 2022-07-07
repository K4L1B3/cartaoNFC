package com.nfc_card_project.nfc_card.rest.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nfc_card_project.nfc_card.domains.models.Perfil;
import com.nfc_card_project.nfc_card.services.PerfilService;

@RestController
@RequestMapping("/myProfile")
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    //create profile
    @PostMapping("/create")
    public ResponseEntity<Object> save(Perfil perfil){
        if(perfilService.existsById(perfil.getId())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Esse usuário ja foi cadastrado.");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(perfilService.save(perfil));
    }

    //Edit profile
    @PostMapping("/editProfile")
    public ResponseEntity<Object> updateProfile(@PathVariable (value = "id")Long id, @RequestBody Perfil perfil){

        Optional<Perfil> perfilOptional = perfilService.findById(id);
        
        if(!perfilOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Perfil náo encontrado!");
        }

        var atualizarPerfil = new Perfil();
        BeanUtils.copyProperties(perfil, atualizarPerfil);
        perfil.setId(perfilOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(perfilService.save(atualizarPerfil));

    }



    
}
