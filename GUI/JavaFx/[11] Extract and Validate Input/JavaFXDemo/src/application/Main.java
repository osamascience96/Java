package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;


public class Main extends Application{
	
	private Stage window;
	private Scene scene;
	private Button button;
	private Label message;
	
	private int width = 300;
	private int height = 250;
	
	@Override
	public void start(Stage primaryStage) {
		this.window = primaryStage;
		this.window.setTitle("OsamaScience96");
		
		// form 
		this.message = new Label();
		
		TextField ageInput = new TextField();
		ageInput.setPromptText("Enter User Age");
		
		this.button = new Button("Get Age");
		this.button.setOnAction(e -> this.isInt(ageInput, ageInput.getText()));
		
		// set layout
		VBox layout = new VBox(10);
		layout.setPadding(new Insets(20, 20, 20, 20));
		layout.getChildren().addAll(this.message, ageInput, this.button);
		
		// set the scene
		this.scene = new Scene(layout, this.width, this.height);
		this.scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		this.window.setScene(this.scene);
		this.window.show();
		
	}
	
	public boolean isInt(TextField ageField, String number) {
		
		// remove all the classes
		ageField.getStyleClass().removeAll("success", "error");
		this.message.getStyleClass().removeAll("success_text", "error_text");
		
		try {
			int age = Integer.parseInt(number);
			this.message.setText("User is " + number);
			this.message.getStyleClass().add("success_text");
			ageField.getStyleClass().add("success");
			return true;
		} catch (NumberFormatException e) {
			this.message.setText("Error: " + number + " is not a number");
			this.message.getStyleClass().add("error_text");
			ageField.getStyleClass().add("error");
			return false;
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
