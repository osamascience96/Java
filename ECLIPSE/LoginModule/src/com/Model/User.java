package com.Model;

public class User {
	private int id;
	private String name;
	private String username;
	private String password;
	
	public User(int id, String name, String username, String password) {
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
	}
	
	// set id
	public void SetId(int id) {
		this.id = id;
	}
	public int GetId() {
		return this.id;
	}
	
	// set name
	public void SetName(String name) {
		this.name = name;
	}
	public String GetName() {
		return this.name;
	}
	
	// set username
	public void SetUsername(String username) {
		this.username = username;
	}
	public String GetUsername() {
		return this.username;
	}
	
	// set password
	public void SetPassword(String password) {
		this.password = password;
	}
	public String GetPassword() {
		return this.password;
	}
}
