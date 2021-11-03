package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Group group = new Group();
			Scene scene = new Scene(group,	Color.BLACK);
			Image icon = new Image("icon.png");
			primaryStage.getIcons().add(icon);
			primaryStage.setTitle("Stage Demo Program");
			primaryStage.setScene(scene);
			primaryStage.setWidth(500);
			primaryStage.setHeight(500);
			primaryStage.setResizable(false);
			// full screen options
			primaryStage.setFullScreen(true);
			primaryStage.setFullScreenExitHint("You can't escape, unless you press q");
			primaryStage.setFullScreenExitKeyCombination(KeyCombination.valueOf("q"));
//			primaryStage.setX(50);
//			primaryStage.setY(50);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
