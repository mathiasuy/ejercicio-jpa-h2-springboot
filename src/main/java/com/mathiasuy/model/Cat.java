package com.mathiasuy.model;

import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Transient;

import com.mathiasuy.requests.CatRequest;
import com.mathiasuy.requests.PetRequest;
import com.mathiasuy.responses.CatResponse;
import com.mathiasuy.responses.PetResponse;
import com.mathiasuy.responses.ToyResponse;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Cat extends Pet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String hair;
	
	public Cat() {
	}

	public Cat(String name, int age, String hair) {
		super(name, age);
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
		return super.toString() + " Cat [hair=" + hair + "]";
	}

	@Override
	public void setParameters(PetRequest pet) {
		super.setParameters(pet);
		this.setHair(((CatRequest)pet).getHair());
	}
	
	@Transient
	@Override
	public PetResponse getResponse() {
		
		return new CatResponse(super.getId(), super.getName(), super.getAge(), getHair(),
				this.getToys().stream().map(t -> new ToyResponse(t.getName(), t.getDescription())).collect(Collectors.toList())
				);
	}
	
}
