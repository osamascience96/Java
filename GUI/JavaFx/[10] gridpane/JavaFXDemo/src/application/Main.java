package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


public class Main extends Application{
	
	private Stage window;
	private int width = 600;
	private int height = 300;
	
	@Override
	public void start(Stage primaryStage) {
		this.window = primaryStage;
		this.window.setTitle("My Some Program");		
		
		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(10, 10, 10, 10));
		gridPane.setVgap(8);
		gridPane.setHgap(10);
		
		Label nameLabel = new Label("Username: ");
		GridPane.setConstraints(nameLabel, 0, 0);
		TextField nameInput = new TextField("Osama");
		GridPane.setConstraints(nameInput, 1, 0);
		
		Label passLabel = new Label("Password: ");
		GridPane.setConstraints(passLabel, 0, 1);
		TextField passInputField = new TextField();
		passInputField.setPromptText("password");
		GridPane.setConstraints(passInputField, 1, 1);
		
		Button loginButton = new Button("Login");
		GridPane.setConstraints(loginButton, 1, 2);
		
		gridPane.getChildren().addAll(nameLabel, nameInput, passLabel, passInputField, loginButton);
		
		Scene scene = new Scene(gridPane, width, height);
		this.window.setScene(scene);
		this.window.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
