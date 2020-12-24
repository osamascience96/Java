package state;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		var watchContext = new WatchContext();
		
		watchContext.SetState(new StartWatch());
		watchContext.GetState().click();
		
		watchContext.SetState(new StopWatch());
		watchContext.GetState().click();
		
		watchContext.SetState(new StartWatch());
		watchContext.GetState().click();
	}

}

