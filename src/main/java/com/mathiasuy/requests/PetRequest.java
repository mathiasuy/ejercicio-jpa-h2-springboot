package com.mathiasuy.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;



//@JsonDeserialize(as=(()?DogRequest.class:CatRequest.class) )
@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "type")
@JsonSubTypes({
	@JsonSubTypes.Type(value = CatRequest.class, name = "cat"),
	@JsonSubTypes.Type(value = DogRequest.class, name = "dog")
})
public abstract class PetRequest {

	private Long id;
	private String name;
	private int age;
	
	public PetRequest() {
		super();
	}
	
	public PetRequest(Long id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	@JsonProperty(required = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonProperty
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "PetRequest [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
}
