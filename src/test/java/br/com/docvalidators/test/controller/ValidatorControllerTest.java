package br.com.docvalidators.test.controller;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.boot.test.context.SpringBootTest;
import br.com.docvalidators.controller.ValidatorController;
import org.springframework.test.web.servlet.MockMvc;
import org.apache.logging.log4j.LogManager;
import org.springframework.http.MediaType;
import org.junit.jupiter.api.BeforeEach;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

/**
 * Classe responsável pelos testes unitários da classe {@link ValidatorController}.
 * 
 * @author Felipe Nascimento
 * 
 */

@SpringBootTest
class ValidatorControllerTest {
	private static final Logger LOG = LogManager.getLogger(ValidatorControllerTest.class.getName());
	
	@InjectMocks
	private ValidatorController validatorController;
	
    private MockMvc mockMvc;
	
	/**
	 * Método responsável pela inicialização dos mocks.
	 */
	@BeforeEach
	void setUp() {
		
		mockMvc = MockMvcBuilders.standaloneSetup(validatorController).build();
		
	}
	
	/**
	 * Teste unitário de sucesso do método validatePhone(@RequestParam String phone).
	 */
	@Test
	void testSuccessValidatePhone() {
		
		var endpoint = "/validate-phone";
		var paramName = "phone";
		var param = "(84) 2657-8690";
		var message = String.format("O telefone %s é válido.", param);
		
		auxExecutionTestReq(endpoint, paramName, param, message, true);
		
	}
	
	/**
	 * Teste unitário de erro do método validatePhone(@RequestParam String phone).
	 */
	@Test
	void testErrorValidatePhone() {
		
		var endpoint = "/validate-phone";
		var paramName = "phone";
		var param = "(11) 1234-5678";
		var message = String.format("O telefone %s é inválido.", param);
		
		auxExecutionTestReq(endpoint, paramName, param, message, false);
		
	}
	
	/**
	 * Teste unitário de sucesso do método validateMobile(@RequestParam String mobile).
	 */
	@Test
	void testSuccessValidateMobile() {
		
		var endpoint = "/validate-mobile";
		var paramName = "mobile";
		var param = "(84) 98537-0880";
		var message = String.format("O celular %s é válido.", param);
		
		auxExecutionTestReq(endpoint, paramName, param, message, true);
		
	}
	
	/**
	 * Teste unitário de erro do método validateMobile(@RequestParam String mobile).
	 */
	@Test
	void testErrorValidateMobile() {
		
		var endpoint = "/validate-mobile";
		var paramName = "mobile";
		var param = "(11) 91234-5678";
		var message = String.format("O celular %s é inválido.", param);
		
		auxExecutionTestReq(endpoint, paramName, param, message, false);
		
	}
	
	/**
	 * Teste unitário de sucesso do método validateCnpj(@RequestParam String cnpj).
	 */
	@Test
	void testSuccessValidateCnpj() {
		
		var endpoint = "/validate-cnpj";
		var paramName = "cnpj";
		var param = "32.630.465/0001-12";
		var message = String.format("O CNPJ %s é válido.", param);
		
		auxExecutionTestReq(endpoint, paramName, param, message, true);
		
	}
	
	/**
	 * Teste unitário de erro do método validateCnpj(@RequestParam String cnpj).
	 */
	@Test
	void testErrorValidateCnpj() {
		
		var endpoint = "/validate-cnpj";
		var paramName = "cnpj";
		var param = "89.112.152/0001-22";
		var message = String.format("O CNPJ %s é inválido.", param);
		
		auxExecutionTestReq(endpoint, paramName, param, message, false);
		
	}
	
	/**
	 * Teste unitário de sucesso do método validateCpf(@RequestParam String cpf).
	 */
	@Test
	void testSuccessValidateCpf() {
		
		var endpoint = "/validate-cpf";
		var paramName = "cpf";
		var param = "735.525.450-26";
		var message = String.format("O CPF %s é válido.", param);
		
		auxExecutionTestReq(endpoint, paramName, param, message, true);
		
	}
	
	/**
	 * Teste unitário de erro do método validateCpf(@RequestParam String cpf).
	 */
	@Test
	void testErrorValidateCpf() {
		
		var endpoint = "/validate-cpf";
		var paramName = "cpf";
		var param = "066.196.690-39";
		var message = String.format("O CPF %s é inválido.", param);
		
		auxExecutionTestReq(endpoint, paramName, param, message, false);
		
	}
	
	/**
	 * Teste unitário de sucesso do método validatePis(@RequestParam String pis).
	 */
	@Test
	void testSuccessValidatePis() {
		
		var endpoint = "/validate-pis";
		var paramName = "pis";
		var param = "691.51233.36-2";
		var message = String.format("O PIS %s é válido.", param);
		
		auxExecutionTestReq(endpoint, paramName, param, message, true);
		
	}
	
	/**
	 * Teste unitário de erro do método validatePis(@RequestParam String pis).
	 */
	@Test
	void testErrorValidatePis() {
		
		var endpoint = "/validate-pis";
		var paramName = "pis";
		var param = "691.51233.32-6";
		var message = String.format("O PIS %s é inválido.", param);
		
		auxExecutionTestReq(endpoint, paramName, param, message, false);
		
	}
	
	/**
	 * Teste unitário de sucesso do método validateRg(@RequestParam String rg).
	 */
	@Test
	void testSuccessValidateRg() {
		
		var endpoint = "/validate-rg";
		var paramName = "rg";
		var param = "25.703.350-6";
		var message = String.format("O RG %s é válido.", param);
		
		auxExecutionTestReq(endpoint, paramName, param, message, true);
		
	}
	
	/**
	 * Teste unitário de erro do método validateRg(@RequestParam String rg).
	 */
	@Test
	void testErrorValidateRg() {
		
		var endpoint = "/validate-rg";
		var paramName = "rg";
		var param = "18.097.450-3";
		var message = String.format("O RG %s é inválido.", param);
		
		auxExecutionTestReq(endpoint, paramName, param, message, false);
		
	}
	
	/**
	 * Teste unitário de sucesso do método validateEmail(@RequestParam String email).
	 */
	@Test
	void testSuccessValidateEmail() {
		
		var endpoint = "/validate-email";
		var paramName = "email";
		var param = "softwaredev@3dmaker.com.br";
		var message = String.format("O e-mail %s é válido.", param);
		
		auxExecutionTestReq(endpoint, paramName, param, message, true);
		
	}
	
	/**
	 * Teste unitário de erro do método validateEmail(@RequestParam String email).
	 */
	@Test
	void testErrorValidateEmail() {
		
		var endpoint = "/validate-email";
		var paramName = "email";
		var param = "devsoft@etirama";
		var message = String.format("O e-mail %s é inválido.", param);
		
		auxExecutionTestReq(endpoint, paramName, param, message, false);
		
	}
	
	/**
	 * Teste unitário de sucesso do método validateCep(@RequestParam String cep).
	 */
	@Test
	void testSuccessValidateCep() {
		
		var endpoint = "/validate-cep";
		var paramName = "cep";
		var param = "78710-189";
		var message = String.format("O CEP %s é válido.", param);
		
		auxExecutionTestReq(endpoint, paramName, param, message, true);
		
	}
	
	/**
	 * Teste unitário de erro do método validateCep(@RequestParam String cep).
	 */
	@Test
	void testErrorValidateCep() {
		
		var endpoint = "/validate-cep";
		var paramName = "cep";
		var param = "7871-0189";
		var message = String.format("O CEP %s é inválido.", param);
		
		auxExecutionTestReq(endpoint, paramName, param, message, false);
		
	}
	
	/**
	 * Teste de sucesso do método validateOver18(@RequestParam Integer year, @RequestParam Integer month, @RequestParam Integer dayOfMonth).
	 */
	@Test
	void testSuccessValidateOver18() {
		
		var endpoint = "/validate-over18";
		var paramNameYear = "year";
		var paramNameMonth = "month";
		var paramNameDayOfMonth = "dayOfMonth";
		var paramYear = String.valueOf(2006);
		var paramMonth = String.valueOf(04);
		var paramDayOfMonth = String.valueOf(24);
		var message = "É maior de 18 anos.";
		
		auxExecutionTestReqValidateOver18(endpoint, paramNameYear, paramNameMonth, paramNameDayOfMonth, paramYear, paramMonth, paramDayOfMonth, message, true);
		
	}
	
	/**
	 * Teste de erro do método validateOver18(@RequestParam Integer year, @RequestParam Integer month, @RequestParam Integer dayOfMonth).
	 */
	@Test
	void testErrorValidateOver18() {
		
		var endpoint = "/validate-over18";
		var paramNameYear = "year";
		var paramNameMonth = "month";
		var paramNameDayOfMonth = "dayOfMonth";
		var paramYear = String.valueOf(2008);
		var paramMonth = String.valueOf(07);
		var paramDayOfMonth = String.valueOf(10);
		var message = "É menor de 18 anos.";
		
		auxExecutionTestReqValidateOver18(endpoint, paramNameYear, paramNameMonth, paramNameDayOfMonth, paramYear, paramMonth, paramDayOfMonth, message, false);
		
	}
	
	/**
	 * Teste de sucesso do método validateOver18ISO8601(@RequestParam String dateOfBirth).
	 */
	@Test
	void testSuccessValidateOver18ISO8601() {
		
		var endpoint = "/validate-over18-iso-8601";
		var paramName = "dateOfBirth";
		var param = "1997-01-13";
		var message = "É maior de 18 anos.";
		
		auxExecutionTestReq(endpoint, paramName, param, message, true);
		
	}
	
	/**
	 * Teste de erro do método validateOver18ISO8601(@RequestParam String dateOfBirth).
	 */
	@Test
	void testErrorValidateOver18ISO8601() {
		
		var endpoint = "/validate-over18-iso-8601";
		var paramName = "dateOfBirth";
		var param = "2008-07-10";
		var message = "É menor de 18 anos.";
		
		auxExecutionTestReq(endpoint, paramName, param, message, false);
		
	}
	
	/**
	 * Teste de sucesso do método validateOver18AmericanDate(@RequestParam String dateOfBirth).
	 */
	@Test
	void testSuccessValidateOver18AmericanDate() {
		
		var endpoint = "/validate-over18-americandate";
		var paramName = "dateOfBirth";
		var param = "04/24/2006";
		var message = "É maior de 18 anos.";
		
		auxExecutionTestReq(endpoint, paramName, param, message, true);
		
	}
	
	/**
	 * Teste de erro do método validateOver18AmericanDate(@RequestParam String dateOfBirth).
	 */
	@Test
	void testErrorValidateOver18AmericanDate() {
		
		var endpoint = "/validate-over18-americandate";
		var paramName = "dateOfBirth";
		var param = "07/10/2008";
		var message = "É menor de 18 anos.";
		
		auxExecutionTestReq(endpoint, paramName, param, message, false);
		
	}
	
	/**
	 * Teste de sucesso do método validateOver18CommonDate(@RequestParam String dateOfBirth).
	 */
	@Test
	void testSuccessValidateOver18CommonDate() {
		
		var endpoint = "/validate-over18-commondate";
		var paramName = "dateOfBirth";
		var param = "24/04/2006";
		var message = "É maior de 18 anos.";
		
		auxExecutionTestReq(endpoint, paramName, param, message, true);
		
	}
	
	/**
	 * Teste de erro do método validateOver18CommonDate(@RequestParam String dateOfBirth).
	 */
	@Test
	void testErrorValidateOver18CommonDate() {
		
		var endpoint = "/validate-over18-commondate";
		var paramName = "dateOfBirth";
		var param = "10/07/2008";
		var message = "É menor de 18 anos.";
		
		auxExecutionTestReq(endpoint, paramName, param, message, false);
		
	}
	
	/**
	 * Teste de sucesso do método validateCardNumber(@RequestParam String cardNumber).
	 */
	@Test
	void testSuccessValidateCardNumber() {
		
		var endpoint = "/validate-card-number";
		var paramName = "cardNumber";
		var param = "5553 8718 5758 4258";
		var message = String.format("O cartão com o número %s é válido.", param);
		
		auxExecutionTestReq(endpoint, paramName, param, message, true);
		
	}
	
	/**
	 * Teste de erro do método validateCardNumber(@RequestParam String cardNumber).
	 */
	@Test
	void testErrorValidateCardNumber() {
		
		var endpoint = "/validate-card-number";
		var paramName = "cardNumber";
		var param = "2044 1007 8982 6720";
		var message = String.format("O cartão com o número %s é inválido.", param);
		
		auxExecutionTestReq(endpoint, paramName, param, message, false);
		
	}
	
	/**
	 * Método responsável pelo auxílio na execução das requisições dos testes.
	 * 
	 * @param endpoint - {@link String} - endpoint da requisição
	 * @param paramName - {@link String} - nome do parâmetro da requisição
	 * @param param - {@link String} - parâmetro da requisição
	 * @param message - {@link String} - mensagem da requisição
	 * @param isValid - {@link Boolean} - condição da requisição
	 * 
	 */
	private void auxExecutionTestReq(String endpoint, String paramName, String param, String message, Boolean isValid) {
		
		try {
			
			mockMvc.perform(
				
				MockMvcRequestBuilders.get(endpoint).param(paramName, param).accept(MediaType.APPLICATION_JSON)
				
			).andExpect(
					
				MockMvcResultMatchers.status().isOk()
				
			).andExpect(
				
				MockMvcResultMatchers.jsonPath("$.statusMessage").value(message)
			
			).andExpect(
				
				MockMvcResultMatchers.jsonPath("$.isValid").value(isValid)
			
			);
			
		} catch (Exception e) {
			
			LOG.error("Houve erro no método auxExecutionRequest. Exception: {}", e.getMessage());
			
		}
		
	}
	
	/**
	 * Método responsável pelo auxílio na execução das requisições dos testes do método testErrorValidateOver18().
	 * 
	 * @param endpoint - {@link String} - endpoint da requisição
	 * @param paramNameYear - {@link String} - nome do parâmetro do ano
	 * @param paramNameMonth - {@link String} - nome do parâmetro do mês
	 * @param paramNameDayOfMonth - {@link String} - nome do parâmetro do dia
	 * @param paramYear - {@link String} - parâmetro da requisição ano
	 * @param paramMonth - {@link String} - parâmetro da requisição mês
	 * @param paramDayOfMonth - {@link String} - parâmetro da requisição dia
	 * @param message - {@link String} - mensagem da requisição
	 * @param isValid - {@link Boolean} - condição da requisição
	 * 
	 */
	private void auxExecutionTestReqValidateOver18(String endpoint, String paramNameYear, String paramNameMonth, String paramNameDayOfMonth, String paramYear, String paramMonth, String paramDayOfMonth, String message, Boolean isValid) {
		
		try {
			
			mockMvc.perform(
				
				MockMvcRequestBuilders.get(endpoint)
					.param(paramNameYear, paramYear)
					.param(paramNameMonth, paramMonth)
					.param(paramNameDayOfMonth, paramDayOfMonth)
						.accept(MediaType.APPLICATION_JSON)
				
			).andExpect(
					
				MockMvcResultMatchers.status().isOk()
				
			).andExpect(
				
				MockMvcResultMatchers.jsonPath("$.statusMessage").value(message)
			
			).andExpect(
				
				MockMvcResultMatchers.jsonPath("$.isValid").value(isValid)
			
			);
			
		} catch (Exception e) {
			
			LOG.error("Houve erro no método auxExecutionTestReqValidateOver18. Exception: {}", e.getMessage());
			
		}
		
	}
	
}