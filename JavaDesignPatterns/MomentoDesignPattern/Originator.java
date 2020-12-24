package momento;

public class Originator {
	private String state;
	
	public void createState(String state) {
		this.state = state;
	}
	
	public Momento storeState() {
		return new Momento(this.state);
	}
}

