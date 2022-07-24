package com.nfc_card_project.nfc_card.rest.controller;

import java.util.List;
import java.util.Optional;

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
import com.nfc_card_project.nfc_card.services.UsuarioService;

/**
 * UsuarioController
 */
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/create")
    public ResponseEntity<Object> save(@RequestBody Usuario usuario) {

        if (usuarioService.existsByEmail(usuario.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Esse usuario já está cadastrado");
        }

        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.save(usuario));
    }
    
    @PutMapping("/editUsuario/{id}")
    public ResponseEntity<Object> userEdit(@PathVariable(value = "id") Long id, @RequestBody Usuario usuario) {
        
        Optional<Usuario> usuarioOptional = usuarioService.findById(id);

        if (!usuarioOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado!");
        }

        var atualizarUsuario = new Usuario();
        BeanUtils.copyProperties(usuario, atualizarUsuario);
        usuario.setId(usuarioOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.save(atualizarUsuario));
        
        
    }

    @GetMapping("/listAll")
    public List<Usuario> findAllUsers() {
        return usuarioService.findAll();
    }
    
}