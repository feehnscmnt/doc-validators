package br.com.docvalidators.model;

import org.springframework.http.HttpStatus;
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
public class ResponseModel implements Serializable {
	private static final long serialVersionUID = -4284733158615333908L;
	private String statusMessage;
	private HttpStatus statusRequest;
	private int statusCode;
}