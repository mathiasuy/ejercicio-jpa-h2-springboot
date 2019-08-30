package com.mathiasuy.responses;

import java.util.List;

public class CatResponse extends PetResponse {

	private String hair;

	public CatResponse(Long id, String name, int age, String hair, List<ToyResponse> list) {
		super(id, name, age,list);
		this.hair = hair;
	}

	public String getHair() {
		return hair;
	}

	public void setHair(String hair) {
		this.hair = hair;
	}

	@Override
	public String toString() {
		return super.toString() + " CatResponse [hair=" + hair + "]";
	}

	@Override
	public String type() {
		return "Gato";
	}
	
}
