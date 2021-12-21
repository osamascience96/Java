package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application{
	
	private Stage window;
	private Scene scene;
	
	private int width = 300;
	private int height = 200;
	
	@Override
	public void start(Stage primaryStage) {
		this.window = primaryStage;
		this.window.setTitle("Javafx Demo");
		
		// userinput
		TextField userInput = new TextField();
		userInput.setMaxWidth(200);
		Label firstLabel = new Label("Welcome to the Site ");
		Label secondLabel = new Label("");
		
		HBox horizontalView = new HBox(firstLabel, secondLabel);
		horizontalView.setAlignment(Pos.CENTER);
		
		VBox verticalView = new VBox(10, userInput, horizontalView);
		verticalView.setAlignment(Pos.CENTER);
		
		secondLabel.textProperty().bind(userInput.textProperty());
		
		// set the scene
		this.scene = new Scene(verticalView, this.width, this.height);
		this.scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		this.window.setScene(this.scene);
		this.window.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
