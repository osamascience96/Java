package application;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
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
		
		// init the 2 properties of x and y
		IntegerProperty x = new SimpleIntegerProperty(3);
		IntegerProperty y = new SimpleIntegerProperty();
		
		// bind y with x * 10, so when the value of the x changes the value of the y is also gonna change in proportion
		y.bind(x.multiply(10));
		System.out.println("X: ".concat(String.valueOf(x.getValue())));
		System.out.println("Y: ".concat(String.valueOf(y.getValue())));
		
		// now set the value of x to 9, so y is gonna be 90
		x.setValue(9);
		System.out.println("X: ".concat(String.valueOf(x.getValue())));
		System.out.println("Y: ".concat(String.valueOf(y.getValue())));
		
		StackPane stackPane = new StackPane();
		
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
