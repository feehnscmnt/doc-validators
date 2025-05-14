package br.com.docvalidators.util;

/**
 * Classe de utilidades do DOC-Validators.
 * 
 * @author Felipe Nascimento
 * 
 */

public class ValidatorUtils {
	
	/**
	 * Construtor da classe neutro.
	 */
	private ValidatorUtils() {}
	
	/**
	 * E-mail Regex.
	 */
	public static final String EMAIL_REGEX = "^[\\w\\.-]+@([\\w\\-]+\\.)++[\\w]{2,}$";
	
	/**
	 * International Date Standard ISO 8601 (yyyy-MM-dd).
	 */
	public static final String INTERNATIONAL_DATE_STANDARD_ISO_8601 = "yyyy-MM-dd";
	
	/**
	 * Content-Type.
	 */
	public static final String CONTENT_TYPE = "application/json;charset=UTF-8";
	
	/**
	 * American Date Standard (MM/dd/yyyy).
	 */
	public static final String AMERICAN_DATE_STANDARD = "MM/dd/yyyy";
	
	/**
	 * Common Date Standard (dd/MM/yyyy).
	 */
	public static final String COMMON_DATE_STANDARD = "dd/MM/yyyy";
	
	/**
	 * CEP Regex.
	 */
	public static final String CEP_REGEX = "^[0-9]{5}-[0-9]{3}$";
	
	/**
	 * Expiration Time.
	 */
	public static final long EXPIRATION_TIME = 2 * 60 * 1000L;
	
	/**
	 * Algorithm SHA 256.
	 */
	public static final String ALGORITHM_SHA_256 = "SHA-256";
	
	/**
	 * Key Secret.
	 */
	public static final String KEY_SECRET = "doc-validators";
	
	/**
	 * Username DOC-Validators.
	 */
	public static final String USERNAME = "DOC-Validators";
	
	/**
	 * Algorithm AES.
	 */
	public static final String ALGORITHM_AES = "AES";
	
	/**
	 * Documents Regex.
	 */
	public static final String DOC_REGEX = "\\D";
	
	/**
	 * Nine Digit.
	 */
	public static final String NINE_DIGIT = "9";
	
}