package application;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ListView {
	
	public static void ViewOrder(String shopinglist) {
		Stage stage = new Stage();
		stage.setMinWidth(300);
		stage.setTitle("Your Holy Order");
		
		String message = "Your Following Order is on its way!\n";
		
		Label messageLabel = new Label();
		
		String[] list = shopinglist.split(",");
		for (String holyBook : list) {
			message = message.concat("\t *." + holyBook + "\n");
		}
		
		messageLabel.setText(message);
		messageLabel.getStyleClass().add("listview_message");
		
		StackPane stackPane = new StackPane();
		stackPane.getChildren().add(messageLabel);
		
		Scene scene = new Scene(stackPane, 300, 300);
		scene.getStylesheets().add(ListView.class.getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
}
