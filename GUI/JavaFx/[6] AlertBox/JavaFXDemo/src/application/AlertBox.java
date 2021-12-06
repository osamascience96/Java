package application;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {
	public static void display(String title, String message) {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(300);
		
		Label label1 = new Label();
		label1.setText(message);
		Button closeButton = new Button("Close the Window");
		closeButton.setOnAction(e -> window.close());
		
		VBox vboxLayout = new VBox(10);
		vboxLayout.getChildren().addAll(label1, closeButton);
		vboxLayout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(vboxLayout);
		window.setScene(scene);
		window.showAndWait();
		
	}
}
