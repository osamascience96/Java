package application;
	
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;

import controller.MusicController;
import javafx.application.Application;
import javafx.beans.value.ObservableStringValue;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import pojo.Music;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;


public class Main extends Application {
	
	private Stage window;
	private Scene scene;
	
	private int width = 500;
	private int height = 500;
	
	private MediaPlayer mediaPlayer;
	
	@Override
	public void start(Stage primaryStage) throws SQLException, URISyntaxException {
		this.window = primaryStage;
		this.window.setTitle("Music Player");
		
		BorderPane borderPane = new BorderPane();
		
		MusicController musicController = new MusicController();
		Label headingSongs = new Label("Click on any one song to play");
		
		ArrayList<Music> musicArrayList = musicController.GetMyMusicList();
		VBox vbox = new VBox(10);
		vbox.setPadding(new Insets(10, 10, 10, 10));
		
		vbox.getChildren().add(headingSongs);
		
		for(Music music : musicArrayList) {
			Button musicBtn = new Button(music.getName());
			musicBtn.setAlignment(Pos.CENTER);
			vbox.getChildren().add(musicBtn);
			
			byte[] songBytes = music.getMusic_blob().getBytes(1, (int)music.getMusic_blob().length());
			String encodedSong = Base64.getEncoder().encodeToString(songBytes);
			String data = "base64,".concat(encodedSong);
			
			musicBtn.setOnAction(e -> {
				this.playSong(data);
			});
		}
		
		
		HBox horizontalBox = new HBox();
		
		Button buttonPlay = new Button("Play");
		buttonPlay.setPadding(new Insets(10));
		buttonPlay.setOnAction(e -> this.mediaPlayer.play());
		
		
		Button buttonPause = new Button("Pause");
		buttonPause.setPadding(new Insets(10));
		buttonPause.setOnAction(e -> this.mediaPlayer.pause());
		
		Media media = new Media(getClass().getResource("song.mp3").toURI().toString());
		this.mediaPlayer = new MediaPlayer(media);
		this.mediaPlayer.setAutoPlay(true);
		MediaView mediaView = new MediaView(this.mediaPlayer);
		
		horizontalBox.getChildren().addAll(buttonPlay, buttonPause);
		borderPane.setTop(vbox);
		borderPane.setBottom(horizontalBox);
		borderPane.setLeft(mediaView);
		
		this.scene = new Scene(borderPane, this.width, this.height);
		this.scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		this.window.setScene(this.scene);
		this.window.show();
	}
	
	private void playSong(String data) {
		this.mediaPlayer = new MediaPlayer(new Media(URI.create(data).toString()));
		this.mediaPlayer.play();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
