module MusicCloneGUI {
	requires javafx.controls;
	requires javafx.media;
	requires java.sql;
	requires javafx.base;
	
	opens application to javafx.graphics, javafx.fxml;
}
