package user;

public abstract class User {
	private int id;
	private String name;
	private int age;
	private String cnic;
	
	public User(int id, String name, int age, String cnic) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.cnic = cnic;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCnic() {
		return cnic;
	}

	public void setCnic(String cnic) {
		this.cnic = cnic;
	}
	
	
}
