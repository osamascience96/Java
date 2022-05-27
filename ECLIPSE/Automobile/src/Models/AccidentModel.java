package Models;

public class AccidentModel {
	private int aid;
	private String Date;
	private String city;
	private String state;
	
	public AccidentModel() {
	}
	
	public void SetAccidentId(int aid) {
		this.aid = aid;
	}
	
	public int GetAccidentId() {
		return this.aid;
	}
	
	public void SetDate(String Date) {
		this.Date = Date;
	}
	
	public String GetDate() {
		return this.Date;
	}
	
	public void SetCity(String city) {
		this.city = city;
	}
	
	public String GetCity() {
		return this.city;
	}
	
	public void SetState(String state) {
		this.state = state;
	}
	
	public String GetState() {
		return this.state;
	}
}
