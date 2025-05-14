package br.com.docvalidators.test.controller;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.boot.test.context.SpringBootTest;
import br.com.docvalidators.controller.TokenController;
import org.springframework.test.web.servlet.MockMvc;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import br.com.docvalidators.util.ValidatorUtils;
import org.apache.logging.log4j.LogManager;
import br.com.docvalidators.util.JwtUtils;
import org.springframework.http.MediaType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

/**
 * Classe responsável pelos testes unitários da classe {@link TokenController}.
 * 
 * @author Felipe Nascimento
 * 
 */

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class TokenControllerTest {
	private static final Logger LOG = LogManager.getLogger(TokenControllerTest.class.getName());
	
	@InjectMocks
    private TokenController tokenController;
	
	private MockMvc mockMvc;
	
	/**
	 * Método responsável pela inicialização dos mocks.
	 */
	@BeforeEach
	void setUp() {
		
		mockMvc = MockMvcBuilders.standaloneSetup(tokenController).build();
		
	}
	
	/**
	 * Teste unitário de sucesso do método generateTokenJwt(@RequestParam String username).
	 */
	@Test
	void testSuccessGenerateTokenJwt() {
		
		var username = ValidatorUtils.USERNAME;
		
		Assertions.assertEquals(ValidatorUtils.USERNAME, username);
		
		try {
			
			mockMvc.perform(
					
				MockMvcRequestBuilders.post("/token").param("username", username).contentType(MediaType.APPLICATION_JSON)
				
			).andExpect(
				
				MockMvcResultMatchers.status().isOk()
				
			).andExpect(
				
				MockMvcResultMatchers.jsonPath("$.access_token").value(JwtUtils.generateToken(username))
				
			);
			
		} catch (Exception e) {
			
			LOG.error("Houve erro no método testSuccessGenerateTokenJwt. Exception: {}", e.getMessage());
			
		}
		
	}
	
	/**
	 * Teste unitário de erro do método generateTokenJwt(@RequestParam String username).
	 */
	@Test
	void testErrorGenerateTokenJwt() {
		
		var username = "DOCValidators";
		
		Assertions.assertNotEquals(ValidatorUtils.USERNAME, username);
		
		try {
			
			mockMvc.perform(
					
				MockMvcRequestBuilders.post("/token").param("username", username).contentType(MediaType.APPLICATION_JSON)
				
			).andExpect(
				
				MockMvcResultMatchers.status().isOk()
				
			).andExpect(
				
				MockMvcResultMatchers.jsonPath("$.unauthorized").value(String.format("O usuário %s está incorreto ou é inválido.", username))
				
			);
			
		} catch (Exception e) {
			
			LOG.error("Houve erro no método testErrorGenerateTokenJwt. Exception: {}", e.getMessage());
			
		}
		
	}
	
}