package Models;

public class AutoModel {
	private String vin;
	private String make;
	private int year;
	private String agent_ssn;
	
	public AutoModel() {
	}
	
	public void SetVechileIdentityNo(String vin) {
		this.vin = vin;
	}
	
	public String GetVechileIdentityNo() {
		return this.vin;
	}
	
	public void SetMake(String make) {
		this.make = make;
	}
	
	public String GetMake() {
		return this.make;
	}
	
	public void SetYear(int year) {
		this.year = year;
	}
	
	public int GetYear() {
		return this.year;
	}
	
	public void SetAgentSSN(String agent_ssn) {
		this.agent_ssn = agent_ssn;	
	}
}
