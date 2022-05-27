package student;

import user.User;

public class Student extends User{
	private String degree;
	private String batch;
	
	public Student(int id, String name, int age, String cnic, String degree, String batch) {
		super(id, name, age, cnic);
		this.degree = degree;
		this.batch = batch;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}
}
