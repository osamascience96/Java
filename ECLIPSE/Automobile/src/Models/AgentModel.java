package Models;

public class AgentModel {
	private String SSN;
	private float Sallery;
	
	public AgentModel() {
	}
	
	public void SetSSN(String SSN) {
		this.SSN = SSN;
	}
	
	public String GETSSN() {
		return this.SSN;
	}
	
	public void SetSallery(float Sallery) {
		this.Sallery = Sallery;
	}
	
	public float GetSallery() {
		return this.Sallery;
	}
}
