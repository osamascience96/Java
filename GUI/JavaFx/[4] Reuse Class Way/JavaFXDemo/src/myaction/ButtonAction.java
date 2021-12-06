package myaction;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ButtonAction implements EventHandler<ActionEvent>{
	@Override
	public void handle(ActionEvent arg0) {
		System.out.println("Object used is ".concat(this.toString()));
	}
}
