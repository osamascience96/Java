package bean;

import java.io.InputStream;
import java.sql.Blob;

public class Doctor extends User{
	private int id;
	private int userId;
	private String name;
	private int age;
	private Blob image;
	private InputStream is;
	private String phone;
	private String qualification;
	private int availability;
	private String cures;
	private String nid;
	private int approved;
	private String createdAt;
	
	public Doctor() {
	}

	public Doctor(int id, int userId, String username, String email, String password, String usertype, String name, int age, Blob image, String phone, String qualification,
			int availability, String cures, String nid, int approved, String createdAt) {
		super(userId, username, email, password, usertype, createdAt);
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.age = age;
		this.image = image;
		this.phone = phone;
		this.qualification = qualification;
		this.availability = availability;
		this.cures = cures;
		this.nid = nid;
		this.approved = approved;
		this.createdAt = createdAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getUserId() {
		return this.userId;
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
	
	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public int getAvailability() {
		return availability;
	}

	public void setAvailability(int availability) {
		this.availability = availability;
	}

	public String getCures() {
		return cures;
	}

	public void setCures(String cures) {
		this.cures = cures;
	}

	public String getNid() {
		return nid;
	}

	public void setNid(String nid) {
		this.nid = nid;
	}

	public int getApproved() {
		return approved;
	}

	public void setApproved(int approved) {
		this.approved = approved;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	
	public void SetInputStream(InputStream is) {
		this.is = is;
	}
	
	public InputStream GetInputStream() {
		return this.is;
	}
}
