public class MScStudent extends Person{
	private String researchTitle;
	private String supervisor;
	
	public MScStudent(String fullname, int registrationNumber, String email, String researchTitle, String supervisor) {
		super(fullname, registrationNumber, email);
		this.researchTitle = researchTitle;
		this.supervisor = supervisor;
	}
	
	public String getResearchTitle() {
		return researchTitle;
	}
	public void setResearchTitle(String researchTitle) {
		this.researchTitle = researchTitle;
	}
	public String getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.researchTitle + " " + this.supervisor;
	}
}
