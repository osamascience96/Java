package bean;

public class StatePair {
	private String stateName;
	private String stateAbbreviation;
	
	public StatePair() {
	}
	
	public StatePair(String stateName, String stateAbbreviation) {
		this.stateName = stateName;
		this.stateAbbreviation = stateAbbreviation;
	}
	
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getStateAbbreviation() {
		return stateAbbreviation;
	}
	public void setStateAbbreviation(String stateAbbreviation) {
		this.stateAbbreviation = stateAbbreviation;
	}
	
	
}
