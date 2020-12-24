package momento;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Originator originator = new Originator();
		Caretaker caretaker = new Caretaker();
		
		// creating the state 1
		originator.createState("a");
		caretaker.pushState(originator.storeState());
		
		// creating the state 2
		originator.createState("b");
		caretaker.pushState(originator.storeState());
		
		// creating the state 3
		originator.createState("c");
		caretaker.pushState(originator.storeState());
		
		// creating the state 4
		originator.createState("d");
		caretaker.pushState(originator.storeState());
		
		caretaker.DisplayMomentoList();
		
		System.out.println("Display Previous State Representation");
		
		System.out.println(caretaker.popState().getState());
		System.out.println(caretaker.popState().getState());
		System.out.println(caretaker.popState().getState());
	}

}

