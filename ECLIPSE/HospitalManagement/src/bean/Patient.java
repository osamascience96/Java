package bean;

import java.io.InputStream;
import java.sql.Blob;

public class Patient extends User{
	private int id;
	private int userId;
	private String name;
	private int age;
	private Blob image;
	private InputStream is;
	private String phone;
	private String nid;
	private String createdAt;
	
	public Patient() {
	}

	public Patient(int id, int userId, String username, String email, String password, String usertype, String name, int age, Blob image, String phone, String nid, String createdAt) {
		super(userId, username, email, password, usertype, createdAt);
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.age = age;
		this.image = image;
		this.phone = phone;
		this.nid = nid;
		this.createdAt = createdAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNid() {
		return nid;
	}

	public void setNid(String nid) {
		this.nid = nid;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public InputStream getIs() {
		return is;
	}

	public void setIs(InputStream is) {
		this.is = is;
	}
}
