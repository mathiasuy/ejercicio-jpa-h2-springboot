package com.mathiasuy.exceptions;

public class AlreadyExists extends ServicesException {

	private static final long serialVersionUID = 5040090000099627246L;

	public AlreadyExists(String juguete) {
		super("El juguete " + juguete + " ya existe");
	}
	
	public AlreadyExists() {
		super("El juguete ya existe");
	}
	
}
