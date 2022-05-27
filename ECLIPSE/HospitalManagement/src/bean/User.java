package bean;

public class User {
	private int id;
	private String username;
	private String email;
	private String password;
	private String usertype;
	private String createdAt;
	
	public User() {
	}

	public User(int id, String username, String email, String password, String usertype, String createdAt) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.usertype = usertype;
		this.createdAt = createdAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
}
