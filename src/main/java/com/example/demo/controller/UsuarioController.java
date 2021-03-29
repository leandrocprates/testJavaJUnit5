package com.example.demo.controller;

import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService ;

    @GetMapping("lista-usuarios")
    public List<Usuario> buscaListaUsuario(){
        return usuarioService.findAllUsuario() ;
    }

    @GetMapping("lista-usuarios/{id}")
    public Usuario buscaUsuarioById(@PathVariable("id") int id ){
        return usuarioService.findById(id);
    }

}
