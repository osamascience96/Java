package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class Main extends Application{
	
	private Stage window;
	private int width = 600;
	private int height = 300;
	
	@Override
	public void start(Stage primaryStage) {
		this.window = primaryStage;
		this.window.setTitle("My Some Program");		
		
		// horizontal box layout
		HBox topMenu = new HBox();
		Button buttonA = new Button("File");
		Button buttonB = new Button("Edit");
		Button buttonC = new Button("View");
		topMenu.getChildren().addAll(buttonA, buttonB, buttonC);
		
		// Vertical Box Layout
		VBox leftMenu = new VBox();
		Button buttonD = new Button("News");
		Button buttonE = new Button("Updates");
		Button buttonF = new Button("New Website on the Go");
		leftMenu.getChildren().addAll(buttonD, buttonE, buttonF);
		
		// border pane layout (main layout)
		BorderPane borderPane = new BorderPane();
		// add all the sublayouts to the border layout
		borderPane.setTop(topMenu);
		borderPane.setLeft(leftMenu);
		
		// create scene
		Scene scene = new Scene(borderPane, width, height);
		this.window.setScene(scene);
		this.window.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
