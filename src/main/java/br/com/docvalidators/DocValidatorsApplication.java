package br.com.docvalidators;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import java.io.Serializable;

/**
 * Classe responsável pela inicialização do DOC-Validators.
 * 
 * @author Felipe Nascimento
 * 
 */

@SpringBootApplication
public class DocValidatorsApplication implements Serializable {
	private static final long serialVersionUID = 6925894739714495659L;
	
	/**
	 * Método responsável pela inicialização do DOC-Validators.
	 */
	public static void main(String[] args) {
		
		SpringApplication.run(DocValidatorsApplication.class, args);
		
	}

}