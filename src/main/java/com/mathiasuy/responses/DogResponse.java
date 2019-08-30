package com.mathiasuy.responses;

public class DogResponse extends PetResponse {

	public DogResponse(Long id, String name, int age) {
		super(id,name,age);
	}

	@Override
	public String type() {
		return "Perro";
	}
	
	@Override
	public String toString() {
		return super.toString() + " DogResponse []";
	}
	
}
