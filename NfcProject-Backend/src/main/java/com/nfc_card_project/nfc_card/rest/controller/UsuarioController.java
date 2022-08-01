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

import com.nfc_card_project.nfc_card.domains.models.Usuario;
import com.nfc_card_project.nfc_card.dto.UsuarioSaveRequestBody;
import com.nfc_card_project.nfc_card.dto.UsuarioEditRequestBody;
import com.nfc_card_project.nfc_card.services.UsuarioService;



/**
 * UsuarioController
 */
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/create")
    public ResponseEntity<Object> save(@RequestBody UsuarioSaveRequestBody usuarioSaveRequestBody) {

        if (usuarioService.existsByEmail(usuarioSaveRequestBody.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Esse usuario já está cadastrado");
        }

        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.save(usuarioSaveRequestBody));
    }
    
    @PutMapping("/editUsuario/{id}")
    public ResponseEntity<Usuario> userEdit(@PathVariable(value = "id") Long id, @RequestBody UsuarioEditRequestBody usuarioEditRequestBody) {
        
        Usuario usuario = usuarioService.findById(id);
        
        var atualizarUsuario = new UsuarioEditRequestBody();
        BeanUtils.copyProperties(usuarioEditRequestBody, atualizarUsuario);
        usuarioEditRequestBody.setId(usuario.getId());
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.saveEdit(atualizarUsuario));
        
        
    }

    @GetMapping("/listAll")
    public List<Usuario> findAllUsers() {
        return usuarioService.findAll();
    }
    
}