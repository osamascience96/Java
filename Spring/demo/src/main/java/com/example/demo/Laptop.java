package com.example.demo;

import org.springframework.stereotype.Component;

@Component("mylaptop")
public class Laptop {
	private int lid;
	private String brand;
	
	public Laptop() {
	}
	
	public Laptop(int lid, String brand) {
		this.lid = lid;
		this.brand = brand;
	}

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Laptop [lid=" + lid + ", brand=" + brand + "]";
	}
	
	public void compile() {
		System.out.println("Compiling...");
	}
}
