package com.nfc_card_project.nfc_card.rest.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nfc_card_project.nfc_card.domains.models.Perfil;
import com.nfc_card_project.nfc_card.dto.PerfilSaveRequestBody;
import com.nfc_card_project.nfc_card.services.PerfilService;

@RestController
@RequestMapping("/myProfile")
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    //create profile
    @PostMapping("/create")
    public ResponseEntity<Object> save(@RequestBody PerfilSaveRequestBody perfilRequestBodyDto){
        
        return ResponseEntity.status(HttpStatus.CREATED).body(perfilService.save(perfilRequestBodyDto));
    }

    // //Edit profile
    // @PostMapping("/editProfile/{id}")
    // public ResponseEntity<Object> updateProfile(@PathVariable(value = "id") Long id, @RequestBody Perfil perfil) {

    //     Optional<Perfil> perfilOptional = perfilService.findById(id);

    //     if (!perfilOptional.isPresent()) {
    //         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Perfil náo encontrado!");
    //     }

    //     var atualizarPerfil = new Perfil();
    //     BeanUtils.copyProperties(perfil, atualizarPerfil);
    //     perfil.setId(perfilOptional.get().getId());
    //     return ResponseEntity.status(HttpStatus.OK).body(perfilService.save(atualizarPerfil));

    // }
    
    //Listar todos os perfis
    @GetMapping("/findAll")
    public List<Perfil> findAllProfiles() {
        return perfilService.findAll();
    }



    
}
