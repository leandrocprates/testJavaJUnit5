package com.example.demo.service;

import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository ;

    public List<Usuario> findAllUsuario(){
        return usuarioRepository.findAll();
    }

    public Usuario findById(int id ){
        return usuarioRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Usuario não encontrado."));
    }

}
