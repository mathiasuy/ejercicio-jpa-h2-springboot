package com.mathiasuy.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ToyRequest {

	private String name;
	private String description;

	public ToyRequest() {
		super();
	}
	
	public ToyRequest(String name, String description) {
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
		return "ToyRequest [name=" + name + ", description=" + description + "]";
	}
	
}
