
public class Person {
	protected String fullname;
	protected int registrationNumber;
	protected String email;
	
	public Person(String fullname, int registrationNumber, String email) {
		this.fullname = fullname;
		this.registrationNumber = registrationNumber;
		this.email = email;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public int getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(int registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
