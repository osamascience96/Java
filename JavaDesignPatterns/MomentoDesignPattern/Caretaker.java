package momento;

import java.util.ArrayList;
import java.util.List;

public class Caretaker {
	private List<Momento> momentoList;
	
	public Caretaker() {
		this.momentoList = new ArrayList<Momento>();
	}
	
	public void pushState(Momento momentoState) {
		// push the item to the list 
		this.momentoList.add(momentoState);
	}
	
	public Momento popState() {
		// getting the last index of the list
		int lastIndex = momentoList.size() - 1;
		// getting the lastMomentoState from the list
		Momento lastMomentoState = this.momentoList.get(lastIndex);
		// pop the last state from the list
		this.momentoList.remove(lastIndex);
		// return the lastMomentoState
		return lastMomentoState;
	}
	
	public void DisplayMomentoList(){
		for (Momento momento : this.momentoList) {
			System.out.println(momento.getState());
		}
	}
}

