package com.ecommerce.to;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

//@Entity is used to mark this class as an entity bean, so it can be managed by JPA
@Entity
public class Product {
	private int id;
	private String name;
	private float price;

	public Product() {

	}

	public Product(int id, String name, float price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	// @Id annotation specifies the primary key of an entity
	// @GeneratedValue provides for the specification of generation strategies for
	// the values of primary keys
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}