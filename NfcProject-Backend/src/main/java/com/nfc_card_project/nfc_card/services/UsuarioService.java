package com.nfc_card_project.nfc_card.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nfc_card_project.nfc_card.domains.models.Usuario;
import com.nfc_card_project.nfc_card.domains.repositories.UsuarioRepository;
import com.nfc_card_project.nfc_card.dto.UsuarioEditRequestBody;
import com.nfc_card_project.nfc_card.dto.UsuarioSaveRequestBody;
import com.nfc_card_project.nfc_card.mapper.UsuarioEditMapper;
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

    public Usuario save(UsuarioSaveRequestBody usuarioSaveRequestBody) {
        Usuario usuario = UsuarioMapper.toUsuario(usuarioSaveRequestBody, perfilService);
        return usuarioRepository.save(usuario);
    }

    public Usuario saveEdit(UsuarioEditRequestBody usuarioEditRequestBody) {
        Usuario usuario = UsuarioEditMapper.toUsuario(usuarioEditRequestBody, perfilService);
        return usuarioRepository.save(usuario);
    }

    public Usuario findById(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Erro ao buscar id"));
    }

  

  



}
