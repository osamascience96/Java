package com.models;

public class Record {
	private int Id;
	private String name;
	private int age;
	private int love_status;
	private String img_link;
	private String country;
	
	// set the record id
	public void setID(int Id) {
		this.Id = Id;
	}
	public int getID() {
		return this.Id;
	}
	
	// set the name
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	// set the age
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return this.age;
	}
	
	// set the love status
	public void setLoveStatus(int love_status) {
		this.love_status = love_status;
	}
	public int getLoveStatus() {
		return this.love_status;
	}
	
	// set the image link
	public void setImageLink(String img_link) {
		this.img_link = img_link;
	}
	public String getImageLink() {
		return this.img_link;
	}
	
	// set the country name
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCountry() {
		return this.country;
	}
}
