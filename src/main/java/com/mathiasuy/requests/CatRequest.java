package com.mathiasuy.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CatRequest extends PetRequest{

	private String hair;

	public CatRequest() {
		super();
	}

	public CatRequest(String hair) {
		super();
		this.hair = hair;
	}

	@JsonProperty
	public String getHair() {
		return hair;
	}

	public void setHair(String hair) {
		this.hair = hair;
	}

	@Override
	public String toString() {
		return "CatRequest [hair=" + hair + "]";
	}
	
}
