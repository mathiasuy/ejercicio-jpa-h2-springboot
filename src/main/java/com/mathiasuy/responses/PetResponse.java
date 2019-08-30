package com.mathiasuy.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class PetResponse {

	private Long id;
	private String name;
	private int age;
	
	public PetResponse(Long id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	@JsonProperty
	public abstract String type();
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "PetResponse [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

}
