package pojo;

public class User {
	private int id;
	private String name;
	private String email;
	private String type;
	private String password;
	private String CreatedAt;
	
	
	public User() {
	}
	
	public User(int id, String name, String email, String type, String password, String CreatedAt) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.type = type;
		this.password = password;
		this.CreatedAt = CreatedAt;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCreatedAt() {
		return CreatedAt;
	}

	public void setCreatedAt(String createdAt) {
		CreatedAt = createdAt;
	}
	
	
}
