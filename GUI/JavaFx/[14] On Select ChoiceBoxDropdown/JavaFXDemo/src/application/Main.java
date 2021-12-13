package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application{
	
	private Stage window;
	private Scene scene;
	private Button button;
	
	private int width = 300;
	private int height = 300;
	
	@Override
	public void start(Stage primaryStage) {
		this.window = primaryStage;
		this.window.setTitle("Choice Box Demo");
		
		this.button = new Button("Click Me");
		
		ChoiceBox<String> choiceBox = new ChoiceBox<String>();
		choiceBox.getItems().addAll("Apple", "Banana", "Orange", "Pineapple");
		choiceBox.setValue("Apple");
		
		// Listen for selection changes
		/*
		 * The first method called was the choicebox selectionmodel that gets that what type of selection option is this one
		 * The second method calls the selectedItemProperty method that gets the properties of the selected item 
		 * The third method calls the addListener method that contains the callback when any option is selected*/
		// The Call back takes 3 pararms, observatory Option selected, the old value selected and the new value selected
		choiceBox.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue) -> ShowChoiceBoxValues(oldValue, newValue));
		
		this.button.setOnAction(e -> this.getChoice(choiceBox));
		
		// set the layout
		VBox vBoxLayout = new VBox(10);
		vBoxLayout.setPadding(new Insets(20, 20, 20, 20));
		vBoxLayout.getChildren().addAll(choiceBox, this.button);
		
		// set the scene
		this.scene = new Scene(vBoxLayout, this.width, this.height);
		//this.scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		this.window.setScene(this.scene);
		this.window.show();
	}
	
	private void ShowChoiceBoxValues(String oldvalue, String newValue) {
		System.out.println("Old Value was " + oldvalue);
		System.out.println("New Value was " + newValue);
	}
	
	private void getChoice(ChoiceBox<String> choiceBox) {
		String food = choiceBox.getValue();
		System.out.println("Current Value Selected is " + food);
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
