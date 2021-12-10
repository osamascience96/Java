package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application{
	
	private Stage window;
	private Scene scene;
	private Button button;
	private Label message;
	
	private int width = 300;
	private int height = 300;
	
	@Override
	public void start(Stage primaryStage) {
		this.window = primaryStage;
		this.window.setTitle("Al Quds Shop");
		
		// set the message for the user
		this.message = new Label();
		
		// set2
		Label label1 = new Label("Torat of Prophet Musa PBUH");
		CheckBox checkBox1 = new CheckBox("Torat Shareef");
		checkBox1.setSelected(true);
		
		// set2
		Label label2 = new Label("Zabur of Prophet Dawood PBUH");
		CheckBox checkBox2 = new CheckBox("Zabur Shareef");
		
		// set3
		Label label3 = new Label("Injeel of Prophet Esa PBUH");
		CheckBox checkBox3 = new CheckBox("Injeel Shareef");
		
		// set4
		Label label4 = new Label("Quran of Prophet Muhammad PBUH");
		CheckBox checkBox4 = new CheckBox("Quran Shareef");
		
		// order button
		this.button = new Button("Order Now");
		this.button.setOnAction(e -> handleOrder(checkBox1, checkBox2, checkBox3, checkBox4));
		
		// set the layout
		VBox vBoxLayout = new VBox(10);
		vBoxLayout.setPadding(new Insets(20, 20, 20, 20));
		vBoxLayout.getChildren().addAll(this.message, label1, checkBox1, label2, checkBox2, label3, checkBox3, label4, checkBox4, button);
		
		// set the scene
		this.scene = new Scene(vBoxLayout, this.width, this.height);
		this.scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		this.window.setScene(this.scene);
		this.window.show();
	}
	
	private void handleOrder(CheckBox checkBox1, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4) {
		// set the message
		this.message.setText("");
		this.message.getStyleClass().remove("message_text_error");
		String orderlist = "";
		// concatenate all the checked to the orderlist with ,
		if(checkBox1.isSelected())
			orderlist = orderlist.concat("Torat,");
		if(checkBox2.isSelected())
			orderlist = orderlist.concat("Zabur,");
		if(checkBox3.isSelected())
			orderlist = orderlist.concat("Injeel,");
		if(checkBox4.isSelected())
			orderlist = orderlist.concat("Quran,");
		
		// check if the string is empty
		if(orderlist.isEmpty()) {
			this.message.setText("Please select any book");
			this.message.getStyleClass().add("message_text_error");
		}else {
			ListView.ViewOrder(orderlist);
			this.window.close();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
