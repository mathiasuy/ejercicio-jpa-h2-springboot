package com.mathiasuy.exceptions;

public class PetNotFound extends ServicesException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2792192875135821465L;

	public PetNotFound() {
		super("Pet not found!");
	}
	
	public PetNotFound(Long id) {
		super("Pet " + id + " not found!");
	}
	
	public PetNotFound(String message) {
		super(message);
	}

}
