package bean;

public class User {
	private int id;
	private String ssn;
	private String name;
	private String[] courses_id_string;
	private String password;
	
	public User() {
	}
	
	public User(int id, String ssn, String name, String[] courses_id_string, String password) {
		this.id = id;
		this.ssn = ssn;
		this.name = name;
		this.courses_id_string = courses_id_string;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getCourses_id_string() {
		return courses_id_string;
	}

	public void setCourses_id_string(String[] courses_id_string) {
		this.courses_id_string = courses_id_string;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
