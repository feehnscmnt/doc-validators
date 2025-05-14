package br.com.docvalidators.service;

import br.com.docvalidators.util.ValidatorUtils;
import org.springframework.stereotype.Service;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.time.Period;

/**
 * Classe service responsável pelos métodos de validação dos documentos.
 * 
 * @author Felipe Nascimento
 * 
 */

@Service
public class ValidatorService implements Serializable {
	private static final long serialVersionUID = -426658706272280443L;
	
	/**
	 * Método responsável pela validação de números de telefones.
	 * 
	 * @param phone - {@link String} - telefone que será validado
	 * 
	 * @return true se válido / false se inválido
	 * 
	 */
	public boolean isPhone(String phone) {
		
		var digits = Objects.nonNull(phone) ? phone.replaceAll(ValidatorUtils.DOC_REGEX, "") : null;
		
		if (Objects.isNull(digits) || digits.trim().isEmpty() || digits.length() < 10) {
			
			return false;
			
		}
		
		return !(isIncreasing(digits.substring(2)) || isDecreasing(digits.substring(2)) || isRepeated(digits.substring(2)));
		
	}
	
	/**
	 * Método responsável pela validação de números de celulares.
	 * 
	 * @param mobile - {@link String} - celular que será validado
	 * 
	 * @return true se válido / false se inválido
	 * 
	 */
	public boolean isMobile(String mobile) {
		
		var digits = Objects.nonNull(mobile) ? mobile.replaceAll(ValidatorUtils.DOC_REGEX, "") : null;
		
		if (Objects.isNull(digits) || digits.trim().isEmpty()) {
			
			return false;
			
		}
		
		if (!Objects.equals(digits.substring(2, 3), ValidatorUtils.NINE_DIGIT) || digits.length() < 11) {
			
			return false;
			
		}
		
		return !(isIncreasing(digits.substring(3)) || isDecreasing(digits.substring(3)) || isRepeated(digits.substring(3)));
		
	}
	
	/**
	 * Método responsável pela validação de números de CNPJ's.
	 * 
	 * @param cnpj - {@link String} - CNPJ que será validado
	 * 
	 * @return true se válido / false se inválido
	 * 
	 */
	public boolean isCnpj(String cnpj) {
		
		var digits = Objects.nonNull(cnpj) ? cnpj.replaceAll(ValidatorUtils.DOC_REGEX, "") : null;
		
		if (Objects.isNull(digits) || digits.trim().isEmpty() || digits.length() < 14) {
			
			return false;
			
		}
		
		int[] weightCnpj = { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };
		
		return validateDigit(digits, weightCnpj);
		
	}
	
	/**
	 * Método responsável pela validação de números de CPF's.
	 * 
	 * @param cpf - {@link String} - CPF que será validado
	 * 
	 * @return true se válido / false se inválido
	 * 
	 */
	public boolean isCpf(String cpf) {
		
		var digits = Objects.nonNull(cpf) ? cpf.replaceAll(ValidatorUtils.DOC_REGEX, "") : null;
		
	    if (Objects.isNull(digits) || digits.trim().isEmpty() || digits.length() < 11) {
	    	
	        return false;
	        
	    }
	    
	    int[] pesoCpf1 = { 10, 9, 8, 7, 6, 5, 4, 3, 2 };
	    var digit1 = calculateCheckDigit(digits.substring(0, 9), pesoCpf1);
	    
	    if (digit1 != Integer.parseInt(String.valueOf(digits.charAt(9)))) {
	    	
	        return false;
	        
	    }
	    
	    int[] pesoCpf2 = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2 };
	    var digit2 = calculateCheckDigit(digits.substring(0, 10), pesoCpf2);
	    
	    return digit2 == Integer.parseInt(String.valueOf(digits.charAt(10)));
	    
	}
	
	/**
	 * Método responsável pela validação de números de PIS.
	 * 
	 * @param pis - {@link String} - PIS que será validado
	 * 
	 * @return true se válido / false se inválido
	 * 
	 */
	public boolean isPis(String pis) {
		
		var digits = Objects.nonNull(pis) ? pis.replaceAll(ValidatorUtils.DOC_REGEX, "") : null;
		
        if (Objects.isNull(digits) || digits.trim().isEmpty() || digits.length() < 11) {
        	
            return false;
            
        }
        
        int[] weightPis = { 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };
        var sum = 0;
        
        for (var i = 0; i < 10; i++) {
        	
            sum += Integer.parseInt(String.valueOf(digits.charAt(i))) * weightPis[i];
            
        }
        
        var rest = sum % 11;
        var expectedDigit = (rest < 2) ? 0 : 11 - rest;
        
        return Objects.equals(String.valueOf(expectedDigit), String.valueOf(digits.charAt(10)));
        
    }
	
	/**
	 * Método responsável pela validação de números de RG's.
	 * 
	 * @param rg - {@link String} - RG que será validado
	 * 
	 * @return true se válido / false se inválido
	 * 
	 */
	public boolean isRg(String rg) {
		
		var digits = Objects.nonNull(rg) ? rg.replaceAll(ValidatorUtils.DOC_REGEX, "") : null;
		
		return Objects.nonNull(digits) && !digits.trim().isEmpty() && digits.length() >= 9;
		
	}
	
	/**
	 * Método responsável pela validação de e-mails.
	 * 
	 * @param email - {@link String} - e-mail que será validado
	 * 
	 * @return true se válido / false se inválido
	 * 
	 */
	public boolean isEmail(String email) {
		
		if (Objects.isNull(email) || email.trim().isEmpty()) {
        	
            return false;
            
        }
		
		return Pattern.matches(ValidatorUtils.EMAIL_REGEX, email);
		
	}
	
	/**
	 * Método responsável pela validação de números de CEP's.
	 * 
	 * @param cep - {@link String} - cep que será validado
	 * 
	 * @return true se válido / false se inválido
	 * 
	 */
	public boolean isCep(String cep) {
		
		var digits = Objects.nonNull(cep) ? cep : null;
		
		if (Objects.isNull(digits) || digits.trim().isEmpty()) {
        	
            return false;
            
        }
		
		if (!Pattern.matches(ValidatorUtils.CEP_REGEX, digits)) {
			
			return false;
			
		}
		
		return !(isIncreasing(digits.replace("-", "")) || isDecreasing(digits.replace("-", "")) || isRepeated(digits.replace("-", "")));
		
	}
	
	/**
	 * Método responsável pela validação de maiores ou menores de 18 anos.
	 * 
	 * @param dateOfBirth - {@link LocalDate} - data de nascimento
	 * 
	 * @return true se for de maior / false se for de menor
	 * 
	 */
	public boolean isOver18(LocalDate dateOfBirth) {
		
		if (Objects.isNull(dateOfBirth)) {
			
			return false;
			
		}
		
		return Period.between(dateOfBirth, LocalDate.now()).getYears() >= 18;
		
	}
	
	/**
	 * Método responsável pela validação de maiores ou menores de 18 anos
	 * com datas informadas no padrão internacional. Ex.: yyyy-MM-dd
	 * 
	 * @param dateOfBirth - {@link String} - data de nascimento
	 * 
	 * @return true se for de maior / false se for de menor
	 * 
	 */
	public boolean isOver18ISO8601(String dateOfBirth) {
		
		if (Objects.isNull(dateOfBirth) || dateOfBirth.trim().isEmpty()) {
        	
            return false;
            
        }

		return Period.between(LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern(ValidatorUtils.INTERNATIONAL_DATE_STANDARD_ISO_8601)), LocalDate.now()).getYears() >= 18;
		
	}
	
	/**
	 * Método responsável pela validação de maiores ou menores de 18 anos
	 * com datas formatadas no padrão americano. Ex.: MM/dd/yyyy
	 * 
	 * @param dateOfBirth - {@link String} - data de nascimento
	 * 
	 * @return true se for de maior / false se for de menor
	 * 
	 */
	public boolean isOver18AmericanDate(String dateOfBirth) {
		
		if (Objects.isNull(dateOfBirth) || dateOfBirth.trim().isEmpty()) {
        	
            return false;
            
        }

		return Period.between(LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern(ValidatorUtils.AMERICAN_DATE_STANDARD)), LocalDate.now()).getYears() >= 18;
		
	}
	
	/**
	 * Método responsável pela validação de maiores ou menores de 18 anos
	 * com datas formatadas no padrão comum. Ex.: dd/MM/yyyy
	 * 
	 * @param dateOfBirth - {@link String} - data de nascimento
	 * 
	 * @return true se for de maior / false se for de menor
	 * 
	 */
	public boolean isOver18CommonDate(String dateOfBirth) {
		
		if (Objects.isNull(dateOfBirth) || dateOfBirth.trim().isEmpty()) {
        	
            return false;
            
        }

		return Period.between(LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern(ValidatorUtils.COMMON_DATE_STANDARD)), LocalDate.now()).getYears() >= 18;
		
	}
	
	/**
	 * Método responsável pela validação de números de cartão de crédito/débito.
	 * 
	 * @param cardNumber - {@link String} - número do cartão que será validado
	 * 
	 * @return true se válido / false se inválido
	 * 
	 */
	public boolean isCardNumber(String cardNumber) {
		
		var digits = Objects.nonNull(cardNumber) ? cardNumber.replaceAll(ValidatorUtils.DOC_REGEX, "") : null;
		
		if (Objects.isNull(digits) || digits.trim().isEmpty()) {
        	
            return false;
            
        }
		
		if (digits.length() < 13 || digits.length() > 19) {
			
			return false;
			
		}
		
		var alternate = false;
		var sum = 0;

        for (var i = digits.length() - 1; i >= 0; i--) {
        	
            var digit = Character.getNumericValue(digits.charAt(i));

            if (alternate) {
            	
                digit *= 2;
                
                if (digit > 9) {
                	
                    digit -= 9;
                    
                }
                
            }

            sum += digit;
            alternate = !alternate;
            
        }
        
        if (isIncreasing(digits) || isDecreasing(digits) || isRepeated(digits)) {
        	
        	return false;
        	
        }

        return (sum % 10 == 0);
		
	}
	
	/**
	 * Método responsável pela validação dos dígitos verificadores de CNPJ's e CPF's.
	 * 
	 * @param document - CNPJ ou CPF
	 * @param weights - dígitos dos documentos
	 * 
	 * @return true se válido / false se inválido
	 * 
	 */
	private boolean validateDigit(String document, int[] weights) {
		
        var digits = document.substring(0, weights.length);
        var sum = 0;
        
        for (var i = 0; i < weights.length; i++) {
        	
            sum += Integer.parseInt(String.valueOf(digits.charAt(i))) * weights[i];
        }
        
        var rest = sum % 11;
        var expectedDigit = (rest < 2) ? 0 : 11 - rest;
        
        return Objects.equals(String.valueOf(expectedDigit), document.substring(weights.length));
        
    }
	
	/**
	 * Método responsável pelo cálculo dos dígitos verificadores dos CPF's.
	 * 
	 * @param digits - dígitos dos CPF's
	 * @param weights - pesos dos CPF's
	 * 
	 * @return dígitos calculados
	 * 
	 */
	private Integer calculateCheckDigit(String digits, int[] weights) {
		
	    var sum = 0;
	    
	    for (var i = 0; i < digits.length(); i++) {
	    	
	        sum += Integer.parseInt(String.valueOf(digits.charAt(i))) * weights[i];
	        
	    }
	    
	    var rest = sum % 11;
	    
	    return (rest < 2) ? 0 : 11 - rest;
	    
	}
	
	/**
     * Método responsável por validar se há dígitos em ordem crescente.
     * 
     * @param digits - dígitos que serão validados
     * 
     * @return true se houver / false se não houver
     * 
     */
	private boolean isIncreasing(String digits) {
		
        for (var i = 0; i < digits.length() - 1; i++) {
        	
            if (Character.getNumericValue(digits.charAt(i)) >= Character.getNumericValue(digits.charAt(i + 1))) {
            	
                return false;
                
            }
            
        }
        
        return true;
        
    }
	
	/**
     * Método responsável por validar se há dígitos em ordem decrescente.
     * 
     * @param digits - dígitos que serão validados
     * 
     * @return true se houver / false se não houver
     * 
     */
    private boolean isDecreasing(String digits) {
    	
        for (var i = 0; i < digits.length() - 1; i++) {
        	
            if (Character.getNumericValue(digits.charAt(i)) <= Character.getNumericValue(digits.charAt(i + 1))) {
            	
                return false;
                
            }
            
        }
        
        return true;
        
    }
    
    /**
     * Método responsável por validar se há dígitos repetidos.
     * 
     * @param digits - dígitos que serão validados
     * 
     * @return true se houver / false se não houver
     * 
     */
    private boolean isRepeated(String digits) {
    	
        for (var i = 1; i < digits.length(); i++) {
        	
            if (digits.charAt(i) != digits.charAt(0)) {
            	
                return false;
                
            }
            
        }
        
        return true;
        
    }
	
}