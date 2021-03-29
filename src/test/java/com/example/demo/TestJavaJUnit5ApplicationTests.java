package com.example.demo;

import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
class TestJavaJUnit5ApplicationTests {
    @Autowired
    private UsuarioService usuarioService ;

    @Value("${mensagem.ok}")
    private String mensagem ;

    @BeforeEach
    public  void before(){
        System.out.println(mensagem);
    }

    @Test
    public void testBuscaUsuario(){
        List<Usuario>  listaUsuarios =  usuarioService.findAllUsuario();
        Assertions.assertNotNull(listaUsuarios);
    }


}
