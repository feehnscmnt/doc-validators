package br.com.docvalidators.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import br.com.docvalidators.service.ValidatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

/**
 * Classe responsável pelos testes unitários da classe {@link ValidatorService}.
 * 
 * @author Felipe Nascimento
 * 
 */

@SpringBootTest
class ValidatorServiceTest {
	
	@Autowired
	private ValidatorService validatorService;
	
	/**
	 * Teste unitário de sucesso do método isPhone(String phone).
	 */
	@Test
	void testIsPhoneTrue() {
		
		Assertions.assertTrue(validatorService.isPhone("(84) 2657-8690")); // Teste com número válido.
		Assertions.assertTrue(validatorService.isPhone("(11) 4002-0022")); // Teste com número válido.
        
	}
	
	/**
	 * Teste unitário de erro do método isPhone(String phone).
	 */
	@Test
	void testIsPhoneFalse() {
		
		Assertions.assertFalse(validatorService.isPhone(null)); // Teste com valor nulo.
		Assertions.assertFalse(validatorService.isPhone("")); // Teste com valor vazio.
		Assertions.assertFalse(validatorService.isPhone("(11) 1234-567")); // Teste com o número contendo menos dígitos.
		Assertions.assertFalse(validatorService.isPhone("(11) 1234-5678")); // Teste com o número crescente.
		Assertions.assertFalse(validatorService.isPhone("(11) 8765-4321")); // Teste com o número decrescente.
		Assertions.assertFalse(validatorService.isPhone("(11) 9999-9999")); // Teste com o número repetido.
		
	}
	
	/**
	 * Teste unitário de sucesso do método isMobile(String mobile).
	 */
	@Test
	void testIsMobileTrue() {
		
		Assertions.assertTrue(validatorService.isMobile("(84) 98537-0880")); // Teste com número válido.
		Assertions.assertTrue(validatorService.isMobile("(11) 93286-1336")); // Teste com número válido.
		
	}
	
	/**
	 * Teste unitário de erro do método isMobile(String mobile).
	 */
	@Test
	void testIsMobileFalse() {
		
		Assertions.assertFalse(validatorService.isMobile(null)); // Teste com valor nulo.
		Assertions.assertFalse(validatorService.isMobile("")); // Teste com valor vazio.
		Assertions.assertFalse(validatorService.isMobile("(84) 88537-0880")); // Teste com o número sem o dígito '9'.
		Assertions.assertFalse(validatorService.isMobile("(84) 98537-088")); // Teste com o número contendo menos dígitos.
		Assertions.assertFalse(validatorService.isMobile("(11) 91234-5678")); // Teste com o número crescente.
		Assertions.assertFalse(validatorService.isMobile("(11) 98765-4321")); // Teste com o número decrescente.
		Assertions.assertFalse(validatorService.isMobile("(11) 99999-9999")); // Teste com o número repetido.
		
	}
	
	/**
	 * Teste unitário de sucesso do método isCnpj(String cnpj).
	 */
	@Test
	void testIsCnpjTrue() {
		
		Assertions.assertTrue(validatorService.isCnpj("32.630.465/0001-12")); // Teste com número válido.
		Assertions.assertTrue(validatorService.isCnpj("98.121.102/0001-60")); // Teste com número válido.
		
	}
	
	/**
	 * Teste unitário de erro do método isCnpj(String cnpj).
	 */
	@Test
	void testIsCnpjFalse() {
		
		Assertions.assertFalse(validatorService.isCnpj(null)); // Teste com valor nulo.
		Assertions.assertFalse(validatorService.isCnpj("")); // Teste com valor vazio.
		Assertions.assertFalse(validatorService.isCnpj("98.121.102/0001-6")); // Teste com o número contendo menos dígitos.
		Assertions.assertFalse(validatorService.isCnpj("89.112.152/0000-22")); // Teste com o número inválido.
		
	}
	
	/**
	 * Teste unitário de sucesso do método isCpf(String cpf).
	 */
	@Test
	void testIsCpfTrue() {
		
		Assertions.assertTrue(validatorService.isCpf("735.525.450-26")); // Teste com número válido.
		Assertions.assertTrue(validatorService.isCpf("066.196.690-93")); // Teste com número válido.
		
	}
	
	/**
	 * Teste unitário de erro do método isCpf(String cpf).
	 */
	@Test
	void testIsCpfFalse() {
		
		Assertions.assertFalse(validatorService.isCpf(null)); // Teste com valor nulo.
		Assertions.assertFalse(validatorService.isCpf("")); // Teste com valor vazio.
		Assertions.assertFalse(validatorService.isCpf("066.196.690-9")); // Teste com o número contendo menos dígitos.
		Assertions.assertFalse(validatorService.isCpf("066.196.690-39")); // Teste com o primeiro dígito verificador incorreto.
		Assertions.assertFalse(validatorService.isCpf("066.196.690-94")); // Teste com o segundo dígito verificador incorreto.
		
	}
	
	/**
	 * Teste unitário de sucesso do método isPis(String pis).
	 */
	@Test
	void testIsPisTrue() {
		
		Assertions.assertTrue(validatorService.isPis("691.51233.36-2")); // Teste com número válido.
		Assertions.assertTrue(validatorService.isPis("053.33977.95-6")); // Teste com número válido.
		
	}
	
	/**
	 * Teste unitário de erro do método isPis(String pis).
	 */
	@Test
	void testIsPisFalse() {
		
		Assertions.assertFalse(validatorService.isPis(null)); // Teste com valor nulo.
		Assertions.assertFalse(validatorService.isPis("")); // Teste com valor vazio.
		Assertions.assertFalse(validatorService.isPis("053.33977.95")); // Teste com o número contendo menos dígitos.
		Assertions.assertFalse(validatorService.isPis("691.51233.32-6")); // Teste com o número inválido.
		
	}
	
	/**
	 * Teste unitário de sucesso do método isRg(String rg).
	 */
	@Test
	void testIsRgTrue() {
		
		Assertions.assertTrue(validatorService.isRg("25.703.350-6")); // Teste com número válido.
		Assertions.assertTrue(validatorService.isRg("28.057.405-8")); // Teste com número válido.
		
	}
	
	/**
	 * Teste unitário de erro do método isRg(String rg).
	 */
	@Test
	void testIsRgFalse() {
		
		Assertions.assertFalse(validatorService.isRg(null)); // Teste com valor nulo.
		Assertions.assertFalse(validatorService.isRg("")); // Teste com valor vazio.
		Assertions.assertFalse(validatorService.isRg("28.057.405")); // Teste com o número contendo menos dígitos.
		
	}
	
	/**
	 * Teste unitário de sucesso do método isEmail(String email).
	 */
	@Test
	void testIsEmailTrue() {
		
		Assertions.assertTrue(validatorService.isEmail("softwaredev@3dmaker.com.br")); // Teste com e-mail válido.
		Assertions.assertTrue(validatorService.isEmail("devsoft@etirama.com.br")); // Teste com e-mail válido.
		
	}
	
	/**
	 * Teste unitário de erro do método isEmail(String email).
	 */
	@Test
	void testIsEmailFalse() {
		
		Assertions.assertFalse(validatorService.isEmail(null)); // Teste com valor nulo.
		Assertions.assertFalse(validatorService.isEmail("")); // Teste com valor vazio.
		Assertions.assertFalse(validatorService.isEmail("devsoft@etirama")); // Teste com e-mail inválido.
		
	}
	
	/**
	 * Teste unitário de sucesso do método isCep(String cep).
	 */
	@Test
	void testIsCepTrue() {
		
		Assertions.assertTrue(validatorService.isCep("41218-130")); // Teste com o número válido.
		Assertions.assertTrue(validatorService.isCep("59073-127")); // Teste com o número válido.
		
	}
	
	/**
	 * Teste unitário de erro do método isCep(String cep).
	 */
	@Test
	void testIsCepFalse() {
		
		Assertions.assertFalse(validatorService.isCep(null)); // Teste com valor nulo.
		Assertions.assertFalse(validatorService.isCep("")); // Teste com valor vazio.
		Assertions.assertFalse(validatorService.isCep("780741-10")); // Teste com o número incorreto.
		Assertions.assertFalse(validatorService.isCep("78559-65")); // Teste com o número contendo menos dígitos.
		Assertions.assertFalse(validatorService.isCep("12345-678")); // Teste com o número crescente.
		Assertions.assertFalse(validatorService.isCep("87654-321")); // Teste com o número decrescente.
		Assertions.assertFalse(validatorService.isCep("99999-999")); // Teste com o número repetido.
		
	}
	
	/**
	 * Teste unitário de sucesso do método isOver18(LocalDate dateOfBirth).
	 */
	@Test
	void testIsOver18True() {
		
		Assertions.assertTrue(validatorService.isOver18(LocalDate.of(2006, 4, 24))); // Teste com data maior que 18 anos.
		Assertions.assertTrue(validatorService.isOver18(LocalDate.of(1997, 1, 13))); // Teste com data maior que 18 anos.
		
	}
	
	/**
	 * Teste unitário de erro do método isOver18(LocalDate dateOfBirth).
	 */
	@Test
	void testIsOver18False() {
		
		Assertions.assertFalse(validatorService.isOver18(null)); // Teste com valor nulo.
		Assertions.assertFalse(validatorService.isOver18(LocalDate.of(2008, 7, 10))); // Teste com data menor que 18 anos.
		
	}
	
	/**
	 * Teste unitário de sucesso do método isOver18ISO8601(String dateOfBirth).
	 */
	@Test
	void testIsOver18ISO8601True() {
		
		Assertions.assertTrue(validatorService.isOver18ISO8601("2006-04-24")); // Teste com data maior que 18 anos.
		Assertions.assertTrue(validatorService.isOver18ISO8601("1997-01-13")); // Teste com data maior que 18 anos.
		
	}
	
	/**
	 * Teste unitário de erro do método isOver18ISO8601(String dateOfBirth).
	 */
	@Test
	void testIsOver18ISO8601False() {
		
		Assertions.assertFalse(validatorService.isOver18ISO8601(null)); // Teste com valor nulo.
		Assertions.assertFalse(validatorService.isOver18ISO8601("")); // Teste com valor vazio.
		Assertions.assertFalse(validatorService.isOver18ISO8601("2008-07-10")); // Teste com data menor que 18 anos.
		
	}
	
	/**
	 * Teste unitário de sucesso do método isOver18AmericanDate(String dateOfBirth).
	 */
	@Test
	void testIsOver18AmericanDateTrue() {
		
		Assertions.assertTrue(validatorService.isOver18AmericanDate("04/24/2006")); // Teste com data maior que 18 anos.
		Assertions.assertTrue(validatorService.isOver18AmericanDate("01/13/1997")); // Teste com data maior que 18 anos.
		
	}
	
	/**
	 * Teste unitário de erro do método isOver18AmericanDate(String dateOfBirth).
	 */
	@Test
	void testIsOver18AmericanDateFalse() {
		
		Assertions.assertFalse(validatorService.isOver18AmericanDate(null)); // Teste com valor nulo.
		Assertions.assertFalse(validatorService.isOver18AmericanDate("")); // Teste com valor vazio.
		Assertions.assertFalse(validatorService.isOver18AmericanDate("07/10/2008")); // Teste com data menor que 18 anos.
		
	}
	
	/**
	 * Teste unitário de sucesso do método isOver18CommonDate(String dateOfBirth).
	 */
	@Test
	void testIsOver18CommonDateTrue() {
		
		Assertions.assertTrue(validatorService.isOver18CommonDate("24/04/2006")); // Teste com data maior que 18 anos.
		Assertions.assertTrue(validatorService.isOver18CommonDate("13/01/1997")); // Teste com data maior que 18 anos.
		
	}
	
	/**
	 * Teste unitário de erro do método isOver18CommonDate(String dateOfBirth).
	 */
	@Test
	void testIsOver18CommonDateFalse() {
		
		Assertions.assertFalse(validatorService.isOver18CommonDate(null)); // Teste com valor nulo.
		Assertions.assertFalse(validatorService.isOver18CommonDate("")); // Teste com valor vazio.
		Assertions.assertFalse(validatorService.isOver18CommonDate("10/07/2008")); // Teste com data menor que 18 anos.
		
	}
	
	/**
	 * Teste unitário de sucesso do método isCardNumber(String cardNumber).
	 */
	@Test
	void testIsCardNumberTrue() {
		
		Assertions.assertTrue(validatorService.isCardNumber("5553 8718 5758 4258")); // Teste com o número válido.
		Assertions.assertTrue(validatorService.isCardNumber("4024 0071 9882 0762")); // Teste com o número válido.
		
	}
	
	/**
	 * Teste unitário de erro do método isCardNumber(String cardNumber).
	 */
	@Test
	void testIsCardNumberFalse() {
		
		Assertions.assertFalse(validatorService.isCardNumber(null)); // Teste com valor nulo.
		Assertions.assertFalse(validatorService.isCardNumber("")); // Teste com valor vazio.
		Assertions.assertFalse(validatorService.isCardNumber("5553 8718 5758")); // Teste com o número contendo menos dígitos.
		Assertions.assertFalse(validatorService.isCardNumber("4024 0071 9882 0762 0782")); // Teste com o número contendo mais dígitos.
		Assertions.assertFalse(validatorService.isCardNumber("1234 5678 9012 3456")); // Teste com o número crescente.
		Assertions.assertFalse(validatorService.isCardNumber("6543 2109 8765 4321")); // Teste com o número decrescente.
		Assertions.assertFalse(validatorService.isCardNumber("1111 1111 1111 1111")); // Teste com o número repetido.
		Assertions.assertFalse(validatorService.isCardNumber("2044 1007 8982 6720")); // Teste com o número inválido.
		
	}
	
}