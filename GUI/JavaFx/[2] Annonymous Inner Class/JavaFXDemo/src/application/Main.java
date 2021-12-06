package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;


public class Main extends Application{
	
	Button button;
	
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Title of the Window");
		button = new Button();
		button.setText("Click Me");
		// set the button action and passing the annonymous class interface object
		button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("Button is Clicked using the annonymous inner class");
			}
			
		});
		
		// set the layout
		StackPane layout = new StackPane();
		layout.getChildren().add(button);		
		
		// set the secne 
		Scene scene = new Scene(layout, 300, 250);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
