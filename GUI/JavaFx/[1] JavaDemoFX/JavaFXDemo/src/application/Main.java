package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;


public class Main extends Application implements EventHandler<ActionEvent>{
	
	Button button;
	
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Title of the Window");
		button = new Button();
		button.setText("Click Me");
		// set the button action 
		button.setOnAction(this);
		
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
	
	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		if(event.getSource() == this.button) {
			System.out.println("The Button is Clicked");
		}
	}
}
