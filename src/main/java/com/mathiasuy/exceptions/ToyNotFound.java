package com.mathiasuy.exceptions;

public class ToyNotFound extends ServicesException {

	private static final long serialVersionUID = -8644958797592188784L;

	public ToyNotFound(String toy) {
		super("El juguete " + toy + " no existe.");
	}
	
}
