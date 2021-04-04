package com.example.demo;

import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get ;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
class TestJavaJUnit5ApplicationTests {

    @Autowired
    private UsuarioService usuarioService ;

    @Value("${mensagem.ok}")
    private String mensagem ;

    @Autowired
    private MockMvc mockMvc ;

    
    @Autowired
    private ObjectMapper objectMapper ;

    @BeforeEach
    public  void before(){
        System.out.println(mensagem);
    }

    @Test
    public void testBuscaUsuarioRestMvc() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/lista-usuarios")
                ).andExpect(status().isOk());

        MockHttpServletResponse mockHttpServletResponse = resultActions.andReturn().getResponse();
        String response = mockHttpServletResponse.getContentAsString() ;
        int statusCode = mockHttpServletResponse.getStatus() ;
        System.out.println("Response body : "+response);
        System.out.println("Status Code : "+ statusCode);

    }

    @Test
    public void testBuscaUsuarioService(){
        List<Usuario>  listaUsuarios =  usuarioService.findAllUsuario();
        Assertions.assertNotNull(listaUsuarios);
    }

    @Test
    public void testCriarUsuario() throws Exception {
        Usuario usuarioNovo = new Usuario(0,"Novo Usuario",1122333018L );
        ResultActions resultActions = mockMvc.perform(post("/adicionar")
                                                .contentType(MediaType.APPLICATION_JSON)
                                                .content( objectMapper.writeValueAsString(usuarioNovo)) )
                                                .andExpect(status().isOk());

        MockHttpServletResponse mockHttpServletResponse = resultActions.andReturn().getResponse();
        String response = mockHttpServletResponse.getContentAsString() ;
        int statusCode = mockHttpServletResponse.getStatus() ;
        System.out.println("Response body : "+response);
        System.out.println("Status Code : "+ statusCode);
    }

}
