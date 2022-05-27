package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
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
	
	private int width = 500;
	private int height = 500;
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		this.window = primaryStage;
		this.window.setTitle("Javafx Demo");
		
		Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
		
		// set the scene
		this.scene = new Scene(root, this.width, this.height);
		this.scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		this.window.setScene(this.scene);
		this.window.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
