package com.mathiasuy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "toy")
public class Toy  implements java.io.Serializable {

	private static final long serialVersionUID = -4580760072712924691L;
	private String name;
	private String description;

	public Toy() {
		super();
	}
	
	public Toy(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	@Id
	@Column(name = "name", nullable = false, length = 15)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description", nullable = true, length = 50)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Toy [name=" + name + ", description=" + description + "]";
	}
	
}
