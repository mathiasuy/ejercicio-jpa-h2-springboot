package com.mathiasuy.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ToyResponse {

	private String name;
	private String description;

	public ToyResponse() {
		super();
	}
	
	public ToyResponse(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	@JsonProperty
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ToyResponse [name=" + name + ", description=" + description + "]";
	}

	public ToyResponse getResponse() {
		// TODO Auto-generated method stub
		return null;
	}	
	
}
