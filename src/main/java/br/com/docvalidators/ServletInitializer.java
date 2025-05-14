package br.com.docvalidators;

import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Classe responsável pela inicialização do DOC-Validators em um contêiner de Servlet.
 * 
 * @author Felipe Nascimento
 * 
 */

public class ServletInitializer extends SpringBootServletInitializer {
	
	/**
	 * Método responsável por garantir a inicialização do DOC-Validators com as configuração
	 * definidas na classe {@link DocValidatorsApplication}.
	 * 
	 * @param application - {@link SpringApplicationBuilder} - classe que configura a aplicação Spring Boot
	 * 
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DocValidatorsApplication.class);
	}

}