package professor;

import user.User;

public class Professor extends User{
	private double sallery;
	private String qualification;
	
	public Professor(int id, String name, int age, String cnic, int userId, double sallery, String qualification) {
		super(id, name, age, cnic);
		this.sallery = sallery;
		this.qualification = qualification;
	}

	public double getSallery() {
		return sallery;
	}

	public void setSallery(double sallery) {
		this.sallery = sallery;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	
	
}
