package com.mathiasuy.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.mathiasuy.requests.PetRequest;
import com.mathiasuy.responses.PetResponse;

@Entity
@Table(name = "Pet")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pet implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2820951481767461191L;
	
	private Long id;
	private String name;
	private int age;
	@OneToMany(targetEntity=Toy.class, fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST})
	@ElementCollection(targetClass = Toy.class)
	private List<Toy> toys = new ArrayList<>();
	
	public Pet() {
		super();
	}

	public Pet(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public void addToy(Toy toy) {
		this.toys.add(toy);
	}
	
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "toys", nullable = false)
	@ElementCollection(targetClass = Toy.class)	
	public List<Toy> getToys() {
		return toys;
	}

	public void setToys(List<Toy> toys) {
		this.toys = toys;
	}

	@Column(name = "name", nullable = false, length = 15)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "age", length = 2)
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Pet [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

	@Transient
	public abstract PetResponse getResponse();

	public void setParameters(PetRequest pet) {
		this.setAge(pet.getAge());
		this.setName(pet.getName());
		this.setToys(pet.getToys().stream().map(t-> new Toy(t.getName(), t.getDescription())).collect(Collectors.toList()));
	}

}
