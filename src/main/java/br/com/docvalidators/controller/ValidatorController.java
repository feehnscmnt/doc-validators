package br.com.docvalidators.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import br.com.docvalidators.service.ValidatorService;
import br.com.docvalidators.model.ValidatorModel;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import lombok.AllArgsConstructor;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Classe controller responsável pela requisição dos métodos de validação dos documentos.
 * 
 * @author Felipe Nascimento
 *
 */

@RestController
@RequestMapping
@AllArgsConstructor
public class ValidatorController implements Serializable {
	private static final long serialVersionUID = 929740225309665833L;
	private final ValidatorService validatorService;
	
	/**
	 * Método responsável pela requisição de validação de telefone.
	 * 
	 * @param phone - {@link RequestParam} / {@link String} - telefone que será validado
	 * 
	 * @return true se válido / false se inválido
	 * 
	 */
	@GetMapping("/validate-phone")
	public ResponseEntity<Object> validatePhone(@RequestParam String phone) {
		
		var isPhone = validatorService.isPhone(phone);
		
		if (isPhone) {
			
			return ResponseEntity.status(HttpStatus.OK)
				.body(new ValidatorModel(String.format("O telefone %s é válido.", phone), isPhone));
			
		}
		
		return ResponseEntity.status(HttpStatus.OK)
			.body(new ValidatorModel(String.format("O telefone %s é inválido.", phone), false));
		
	}
	
	/**
	 * Método responsável pela requisição de validação de celular.
	 * 
	 * @param mobile - {@link RequestParam} / {@link String} - celular que será validado
	 * 
	 * @return true se válido / false se inválido
	 * 
	 */
	@GetMapping("/validate-mobile")
	public ResponseEntity<Object> validateMobile(@RequestParam String mobile) {
		
		var isMobile = validatorService.isMobile(mobile);
		
		if (isMobile) {
			
			return ResponseEntity.status(HttpStatus.OK)
				.body(new ValidatorModel(String.format("O celular %s é válido.", mobile), isMobile));
			
		}
		
		return ResponseEntity.status(HttpStatus.OK)
			.body(new ValidatorModel(String.format("O celular %s é inválido.", mobile), false));
		
	}
	
	/**
	 * Método responsável pela requisição de validação de CNPJ's.
	 * 
	 * @param cnpj - {@link RequestParam} / {@link String} - CNPJ que será validado
	 * 
	 * @return true se válido / false se inválido
	 * 
	 */
	@GetMapping("/validate-cnpj")
	public ResponseEntity<Object> validateCnpj(@RequestParam String cnpj) {
		
		var isCnpj = validatorService.isCnpj(cnpj);
		
		if (isCnpj) {
			
			return ResponseEntity.status(HttpStatus.OK)
				.body(new ValidatorModel(String.format("O CNPJ %s é válido.", cnpj), isCnpj));
			
		}
		
		return ResponseEntity.status(HttpStatus.OK)
			.body(new ValidatorModel(String.format("O CNPJ %s é inválido.", cnpj), false));
		
	}
	
	/**
	 * Método responsável pela requisição de validação de CPF's.
	 * 
	 * @param cpf - {@link RequestParam} / {@link String} - CPF que será validado
	 * 
	 * @return true se válido / false se inválido
	 * 
	 */
	@GetMapping("/validate-cpf")
	public ResponseEntity<Object> validateCpf(@RequestParam String cpf) {
		
		var isCpf = validatorService.isCpf(cpf);
		
		if (isCpf) {
			
			return ResponseEntity.status(HttpStatus.OK)
				.body(new ValidatorModel(String.format("O CPF %s é válido.", cpf), isCpf));
			
		}
		
		return ResponseEntity.status(HttpStatus.OK)
			.body(new ValidatorModel(String.format("O CPF %s é inválido.", cpf), false));
		
	}
	
	/**
	 * Método responsável pela requisição de validação de PIS.
	 * 
	 * @param pis - {@link RequestParam} / {@link String} - PIS que será validado
	 * 
	 * @return true se válido / false se inválido
	 * 
	 */
	@GetMapping("/validate-pis")
	public ResponseEntity<Object> validatePis(@RequestParam String pis) {
		
		var isPis = validatorService.isPis(pis);
		
		if (isPis) {
			
			return ResponseEntity.status(HttpStatus.OK)
				.body(new ValidatorModel(String.format("O PIS %s é válido.", pis), isPis));
			
		}
		
		return ResponseEntity.status(HttpStatus.OK)
			.body(new ValidatorModel(String.format("O PIS %s é inválido.", pis), false));
		
	}
	
	/**
	 * Método responsável pela requisição de validação de RG's.
	 * 
	 * @param rg - {@link RequestParam} / {@link String} - RG que será validado
	 * 
	 * @return true se válido / false se inválido
	 * 
	 */
	@GetMapping("/validate-rg")
	public ResponseEntity<Object> validateRg(@RequestParam String rg) {
		
		var isRg = validatorService.isPis(rg);
		
		if (isRg) {
			
			return ResponseEntity.status(HttpStatus.OK)
				.body(new ValidatorModel(String.format("O RG %s é válido.", rg), isRg));
			
		}
		
		return ResponseEntity.status(HttpStatus.OK)
			.body(new ValidatorModel(String.format("O RG %s é inválido.", rg), false));
		
	}
	
	/**
	 * Método responsável pela requisição de validação de e-mail.
	 * 
	 * @param email - {@link RequestParam} / {@link String} - e-mail que será validado
	 * 
	 * @return true se válido / false se inválido
	 * 
	 */
	@GetMapping("/validate-email")
	public ResponseEntity<Object> validateEmail(@RequestParam String email) {
		
		var isEmail = validatorService.isEmail(email);
		
		if (isEmail) {
			
			return ResponseEntity.status(HttpStatus.OK)
				.body(new ValidatorModel(String.format("O e-mail %s é válido.", email), isEmail));
			
		}
		
		return ResponseEntity.status(HttpStatus.OK)
			.body(new ValidatorModel(String.format("O e-mail %s é inválido.", email), false));
		
	}
	
	/**
	 * Método responsável pela requisição de validação de CEP's.
	 * 
	 * @param cep - {@link RequestParam} / {@link String} - cep que será validado
	 * 
	 * @return true se válido / false se inválido
	 * 
	 */
	@GetMapping("/validate-cep")
	public ResponseEntity<Object> validateCep(@RequestParam String cep) {
		
		var isCep = validatorService.isCep(cep);
		
		if (isCep) {
			
			return ResponseEntity.status(HttpStatus.OK)
				.body(new ValidatorModel(String.format("O CEP %s é válido.", cep), isCep));
			
		}
		
		return ResponseEntity.status(HttpStatus.OK)
			.body(new ValidatorModel(String.format("O CEP %s é inválido.", cep), false));
		
	}
	
	/**
	 * Método responsável pela requisição de validação de maiores ou menores de 18 anos.
	 * 
	 * @param year - {@link RequestParam} / {@link Integer} - ano
	 * @param month - {@link RequestParam} / {@link Integer} - mês
	 * @param dayOfMonth - {@link RequestParam} / {@link Integer} - dia
	 * 
	 * @return true se for de maior / false se for de menor
	 * 
	 */
	@GetMapping("/validate-over18")
	public ResponseEntity<Object> validateOver18(@RequestParam Integer year, @RequestParam Integer month, @RequestParam Integer dayOfMonth) {
		
		var isOver18 = validatorService.isOver18(LocalDate.of(year, month, dayOfMonth));
		
		if (isOver18) {
			
			return ResponseEntity.status(HttpStatus.OK)
				.body(new ValidatorModel("É maior de 18 anos.", isOver18));
			
		}
		
		return ResponseEntity.status(HttpStatus.OK)
			.body(new ValidatorModel("É menor de 18 anos.", false));
		
	}
	
	/**
	 * Método responsável pela requisição de validação de maiores ou menores de 18 anos
	 * com datas informadas no padrão internacional. Ex.: yyyy-MM-dd
	 * 
	 * @param dateOfBirth - {@link RequestParam} / {@link String} - data de nascimento
	 * 
	 * @return true se for de maior / false se for de menor
	 * 
	 */
	@GetMapping("/validate-over18-iso-8601")
	public ResponseEntity<Object> validateOver18ISO8601(@RequestParam String dateOfBirth) {
		
		var isOver18ISO8601 = validatorService.isOver18ISO8601(dateOfBirth);
		
		if (isOver18ISO8601) {
			
			return ResponseEntity.status(HttpStatus.OK)
				.body(new ValidatorModel("É maior de 18 anos.", isOver18ISO8601));
			
		}
		
		return ResponseEntity.status(HttpStatus.OK)
			.body(new ValidatorModel("É menor de 18 anos.", false));
		
	}
	
	/**
	 * Método responsável pela requisição de validação de maiores ou menores de 18 anos
	 * com datas informadas no padrão americano. Ex.: MM/dd/yyyy
	 * 
	 * @param dateOfBirth - {@link RequestParam} / {@link String} - data de nascimento
	 * 
	 * @return true se for de maior / false se for de menor
	 * 
	 */
	@GetMapping("/validate-over18-americandate")
	public ResponseEntity<Object> validateOver18AmericanDate(@RequestParam String dateOfBirth) {
		
		var isOver18AmericanDate = validatorService.isOver18AmericanDate(dateOfBirth);
		
		if (isOver18AmericanDate) {
			
			return ResponseEntity.status(HttpStatus.OK)
				.body(new ValidatorModel("É maior de 18 anos.", isOver18AmericanDate));
			
		}
		
		return ResponseEntity.status(HttpStatus.OK)
			.body(new ValidatorModel("É menor de 18 anos.", false));
		
	}
	
	/**
	 * Método responsável pela requisição de validação de maiores ou menores de 18 anos
	 * com datas informadas no padrão comum. Ex.: dd/MM/yyyy
	 * 
	 * @param dateOfBirth - {@link RequestParam} / {@link String} - data de nascimento
	 * 
	 * @return true se for de maior / false se for de menor
	 * 
	 */
	@GetMapping("/validate-over18-commondate")
	public ResponseEntity<Object> validateOver18CommonDate(@RequestParam String dateOfBirth) {
		
		var isOver18CommonDate = validatorService.isOver18CommonDate(dateOfBirth);
		
		if (isOver18CommonDate) {
			
			return ResponseEntity.status(HttpStatus.OK)
				.body(new ValidatorModel("É maior de 18 anos.", isOver18CommonDate));
			
		}
		
		return ResponseEntity.status(HttpStatus.OK)
			.body(new ValidatorModel("É menor de 18 anos.", false));
		
	}
	
	/**
	 * Método responsável pela requisição de validação de números de cartão de crédito/débito.
	 * 
	 * @param cardNumber - {@link RequestParam} / {@link String} - número do cartão que será validado
	 * 
	 * @return true se válido / false se inválido
	 * 
	 */
	@GetMapping("/validate-card-number")
	public ResponseEntity<Object> validateCardNumber(@RequestParam String cardNumber) {
		
		var isCardNumber = validatorService.isCardNumber(cardNumber);
		
		if (isCardNumber) {
			
			return ResponseEntity.status(HttpStatus.OK)
				.body(new ValidatorModel(String.format("O cartão com o número %s é válido.", cardNumber), isCardNumber));
			
		}
		
		return ResponseEntity.status(HttpStatus.OK)
			.body(new ValidatorModel(String.format("O cartão com o número %s é inválido.", cardNumber), false));
		
	}
	
}