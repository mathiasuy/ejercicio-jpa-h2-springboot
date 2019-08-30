package com.mathiasuy.responses;

import java.util.List;

public class DogResponse extends PetResponse {

	public DogResponse(Long id, String name, int age, List<ToyResponse> list) {
		super(id,name,age, list);
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
