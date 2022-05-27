package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class Controller implements Initializable{
	
	public Button button;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
			System.out.println("View is not loaded");
	}
	
	public void handleSubmit() {
		System.out.println("Submit Button has been Handled");
		button.setText("Submit Text Changed on Click");
	}
}
