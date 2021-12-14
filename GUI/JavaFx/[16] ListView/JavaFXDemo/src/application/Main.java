package application;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application{
	
	private Stage window;
	private Scene scene;
	private Button button;
	
	private int width = 300;
	private int height = 300;
	
	@Override
	public void start(Stage primaryStage) {
		this.window = primaryStage;
		this.window.setTitle("ListView");
		
		ListView<String> listView = new ListView<String>();
		listView.getItems().addAll("Iron Man", "Titanic", "Men in Black", "Avengers");
		listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
		
		
		this.button = new Button("Select Movies");
		this.button.setOnAction(e -> submitmovieslist(listView));
		
		// set the layout
		VBox vBoxLayout = new VBox(10);
		vBoxLayout.setPadding(new Insets(20, 20, 20, 20));
		vBoxLayout.getChildren().addAll(listView, this.button);
		
		// set the scene
		this.scene = new Scene(vBoxLayout, this.width, this.height);
		//this.scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		this.window.setScene(this.scene);
		this.window.show();
	}
	
	private void submitmovieslist(ListView<String> listView) {
		String message = "";
		ObservableList<String> movies = listView.getSelectionModel().getSelectedItems();
		
		for (String movie : movies) {
			message += movie + ",";
		}
		
		System.out.println("Following selected Movies");
		System.out.println(message);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
