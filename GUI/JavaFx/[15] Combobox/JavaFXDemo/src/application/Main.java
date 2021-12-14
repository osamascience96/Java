package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
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
		this.window.setTitle("Combobox");
		
		ComboBox<String> combobox = new ComboBox<String>();
		combobox.getItems().addAll("Prophet Muhammad The Last Prophet", "Prophet Jesus Movie", "Prophet Yousuf Season", "Prophet Ibrahim Movie");
		combobox.setPromptText("Select Your Favorite Movie");
		// on select any movie
		combobox.setOnAction(e -> System.out.println("Movie Selected is: " + combobox.getValue()));
		
		this.button = new Button("Order Now");
		this.button.setOnAction(e -> SetOrder(combobox.getValue()));
		
		// set the layout
		VBox vBoxLayout = new VBox(10);
		vBoxLayout.setPadding(new Insets(20, 20, 20, 20));
		vBoxLayout.getChildren().addAll(combobox, this.button);
		
		// set the scene
		this.scene = new Scene(vBoxLayout, this.width, this.height);
		//this.scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		this.window.setScene(this.scene);
		this.window.show();
	}
	
	private void SetOrder(String moviename) {
		System.out.println("You Ordered " + moviename);
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
