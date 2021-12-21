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
import javafx.scene.layout.StackPane;
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
		
		Person person = new Person();
		
		// on property name change
		person.firstNameProperty().addListener((oberserve, oldvalue, newvalue) -> {
			System.out.println("Name Changed to ".concat(newvalue));
			System.out.println("firstNameProperty(): ".concat(person.firstNameProperty().toString()));
			System.out.println("getFirstName(): ".concat(person.getFirstName()));
		});
		
		Button button = new Button("Click");
		button.setOnAction(e -> person.setFirstName("Ahmad"));
		
		StackPane stackPane = new StackPane();
		stackPane.getChildren().add(button);
		
		// set the scene
		this.scene = new Scene(stackPane, this.width, this.height);
		this.scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		this.window.setScene(this.scene);
		this.window.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
