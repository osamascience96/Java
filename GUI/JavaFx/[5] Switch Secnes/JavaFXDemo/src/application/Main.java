package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class Main extends Application{
	
	private Stage window;
	private Scene scene1;
	private Scene scene2;
	
	private int width = 600;
	private int height = 300;
	
	@Override
	public void start(Stage primaryStage) {
		this.window = primaryStage;
		
		Label label1 = new Label("Welcome to the first Scene");
		Button button1 = new Button("Go to Scene 2");
		button1.setOnAction(e -> window.setScene(scene2));
		
		// Layout - Children layout to vertical stack
		VBox layout1 = new VBox(20);
		layout1.getChildren().addAll(label1, button1);
		// set the layout to the scene 
		scene1 = new Scene(layout1, width, height);
		
		//Button 2
		Button button2 = new Button("Go to Scene 1");
		button2.setOnAction(e -> window.setScene(scene1));
		
		// Layout StackPane
		StackPane stackPane = new StackPane();
		stackPane.getChildren().addAll(button2);
		
		// set the layout to the scene
		scene2 = new Scene(stackPane, width, height);
		
		// set the first scene to the window
		this.window.setScene(scene1);
		// set the title of the window
		this.window.setTitle("Switching Scenes");
		
		// display the stage
		this.window.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
