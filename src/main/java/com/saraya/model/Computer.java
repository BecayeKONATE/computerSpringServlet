package com.saraya.model;

import javax.validation.constraints.Size;

public class Computer {

	private int id;
	@Size(min = 2, message = "Enter at least 2 digits")
	private String make;
	private String model;
	private String price;
	private String image;
	
	public Computer(int id, String make, String model, String price, String image) {
		this.id = id;
		this.make = make;
		this.model = model;
		this.price = price;
		this.image = image;
	}

	public Computer() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Computer [id=" + id + ", make=" + make + ", model=" + model + ", price=" + price + ", image=" + image
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Computer other = (Computer) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
