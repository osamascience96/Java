package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;


public class Main extends Application{
	
	private Stage window;
	private Button button;
	private int width = 600;
	private int height = 300;
	
	@Override
	public void start(Stage primaryStage) {
		this.window = primaryStage;
		this.window.setTitle("My Some Program");
		
		window.setOnCloseRequest(e -> {
			e.consume();
			this.closeWindow();
		});
		
		this.button = new Button("Close the Program");
		this.button.setOnAction(e -> {
			this.closeWindow();
		});
		
		// layout 
		StackPane stackPaneLayout = new StackPane();
		stackPaneLayout.getChildren().add(button);
		
		// create scene
		Scene scene = new Scene(stackPaneLayout, width, height);
		this.window.setScene(scene);
		this.window.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	public void closeWindow() {
		// do write logic on close
		Boolean answer = ConfirmBox.display("Are you sure?", "Do you really want to close the Program?");
		if(answer)
			this.window.close();
	}
}
