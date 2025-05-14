package br.com.docvalidators.model;

import lombok.AllArgsConstructor;
import java.io.Serializable;
import lombok.Data;

/**
 * Classe model para tratamento das mensagens das requisições sem Token JWT.
 * 
 * @author Felipe Nascimento
 *
 */

@Data
@AllArgsConstructor
public class ValidatorModel implements Serializable {
	private static final long serialVersionUID = 2266297007746596128L;
	private String statusMessage;
	private boolean isValid;
}