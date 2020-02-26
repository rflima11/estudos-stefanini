package com.stefanini.produtos.service.exceptions;

public class NomeNuloException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NomeNuloException(String msg) {
		super(msg);
	}
	
	public NomeNuloException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
}
