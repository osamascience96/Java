package state;

public class WatchContext {
	private State state;
	
	public WatchContext() {
	}
	
	public void SetState(State state) {
		this.state = state;
	}
	
	public State GetState() {
		return this.state;
	}
}

