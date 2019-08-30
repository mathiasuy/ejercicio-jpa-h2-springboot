package com.mathiasuy.model;

import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Transient;

import com.mathiasuy.requests.PetRequest;
import com.mathiasuy.responses.DogResponse;
import com.mathiasuy.responses.PetResponse;
import com.mathiasuy.responses.ToyResponse;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Dog extends Pet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5350412179980881367L;

	public Dog() {
	}

	public Dog(String name, int age) {
		super(name, age);
	}

	@Override
	public String toString() {
		return "Dog [getId()=" + getId() + ", getName()=" + getName() + ", getAge()=" + getAge() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

	@Override
	public void setParameters(PetRequest pet) {
		super.setParameters(pet);
	}
	
	@Transient
	@Override
	public PetResponse getResponse() {
		return new DogResponse(super.getId(), super.getName(), super.getAge(),
		this.getToys().stream().map(t -> new ToyResponse(t.getName(), t.getDescription())).collect(Collectors.toList()));
	}

}
