package application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {
	
	private static boolean answer;
	
	public static boolean display(String title, String message) {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setMinWidth(300);
		window.setTitle(title);
		Label label1 = new Label();
		label1.setText(message);
		
		Button yesButton = new Button("Yes");
		Button noButton = new Button("No");
		
		yesButton.setOnAction(e -> {
			answer = true;
			window.close();
		});
		
		noButton.setOnAction(e -> {
			answer = false;
			window.close();
		});
		
		VBox vboxLayout = new VBox(20);
		vboxLayout.getChildren().addAll(label1, yesButton, noButton);
		vboxLayout.setAlignment(Pos.CENTER);
		Scene scene = new Scene(vboxLayout);
		window.setScene(scene);
		window.showAndWait();
		
		return answer;
	}
}
