package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
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
		
		// gridpane with 10 pixel of padding
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8);
		grid.setHgap(10);
		
		// Name Label
		Label nameLabel = new Label("Username");
		nameLabel.setId("bold-label");
		GridPane.setConstraints(nameLabel, 0, 0);
		
		// Name Input 
		TextField nameText = new TextField();
		nameText.setPromptText("Enter Username");
		GridPane.setConstraints(nameText, 1, 0);
		
		// Password Label 
		Label passwordLabel = new Label("Password");
		passwordLabel.setId("bold-label");
		GridPane.setConstraints(passwordLabel, 0, 1);
		
		// Password Input
		TextField passwordText = new TextField();
		passwordText.setPromptText("Enter Password");
		GridPane.setConstraints(passwordText, 1, 1);
		
		//Login
		Button loginButton = new Button("Login");
		GridPane.setConstraints(loginButton, 1, 2);
		
		// Signup
		Button signupButton = new Button("Sign Up");
		signupButton.getStyleClass().add("button-blue");
		GridPane.setConstraints(signupButton, 1, 3);
		
		// set all the components on the gridpane
		grid.getChildren().addAll(nameLabel, nameText, passwordLabel, passwordText, loginButton, signupButton);
		
		// set the scene
		this.scene = new Scene(grid, this.width, this.height);
		this.scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		this.window.setScene(this.scene);
		this.window.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
