package com.nfc_card_project.nfc_card.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nfc_card_project.nfc_card.domains.models.Usuario;
import com.nfc_card_project.nfc_card.domains.repositories.UsuarioRepository;
import com.nfc_card_project.nfc_card.dto.UsuarioRequestBody;
import com.nfc_card_project.nfc_card.mapper.UsuarioMapper;

@Service
public class UsuarioService {
    
    @Autowired
    PerfilService perfilService;

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public boolean existsByEmail(String email) {
        return usuarioRepository.existsByEmail(email);
    }

    public Usuario save(UsuarioRequestBody usuarioRequestBody) {
        Usuario usuario = UsuarioMapper.toUsuario(usuarioRequestBody, perfilService);
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

  

  



}
