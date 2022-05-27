package POJO;

public class User {
	private String username;
	private String password;
	
	public User() {
	}
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public void SetUsername(String username) {
		this.username = username;
	}
	public String GetUsername() {
		return this.username;
	}
	
	public void SetPassword(String password) {
		this.password = password;
	}
	public String GetPassword() {
		return this.password;
	}
}
