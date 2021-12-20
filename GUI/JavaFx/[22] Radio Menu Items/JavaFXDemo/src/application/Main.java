package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application{
	
	private Stage window;
	private Scene scene;
	
	private int width = 500;
	private int height = 300;
	
	@Override
	public void start(Stage primaryStage) {
		this.window = primaryStage;
		this.window.setTitle("Menus");
		
		// File Menu
		Menu fileMenu = new Menu("File");
		// menu items
		fileMenu.getItems().add(new MenuItem("New Project..."));
		fileMenu.getItems().add(new MenuItem("New Module..."));
		fileMenu.getItems().add(new MenuItem("Import Project..."));
		fileMenu.getItems().add(new SeparatorMenuItem());
		fileMenu.getItems().add(new MenuItem("Save..."));
		fileMenu.getItems().add(new SeparatorMenuItem());
		fileMenu.getItems().add(new MenuItem("Exit"));
		
		// You can also do like this to set the action on any menu item
		fileMenu.getItems().get(0).setOnAction(e -> System.out.println("Create A New Project..."));
		
		// Edit Menu
		Menu editMenu = new Menu("_Edit"); // underscore will let the user press alt+e to open the edit menu
		// edit items
		editMenu.getItems().add(new MenuItem("Undo Typing"));
		editMenu.getItems().add(new MenuItem("Redo"));
		editMenu.getItems().add(new MenuItem("Cut"));
		editMenu.getItems().add(new MenuItem("Copy"));
		
		editMenu.getItems().get(1).setDisable(true);
		
		// Help Menu
		Menu helpMenu = new Menu("Help");
		helpMenu.getItems().add(new CheckMenuItem("Show Line Numbers"));
		helpMenu.getItems().add(new CheckMenuItem("Enable Autosave"));
		
		helpMenu.getItems().get(0).setOnAction(e -> {
			CheckMenuItem menuItem = (CheckMenuItem) e.getSource();
			if(menuItem.isSelected())
				System.out.println("Program will now display the line numbers");
			else
				System.out.println("Hiding the Line Numbers");
		});
		helpMenu.getItems().get(1).setOnAction(e -> {
			CheckMenuItem menuItem = (CheckMenuItem) e.getSource();
			if(menuItem.isSelected())
				System.out.println("Autosave Enabled");
			else
				System.out.println("Autosaved Disabled");
		});
		
		// RadioMenu Items
		Menu difficultyMenu = new Menu("Difficulty");
		ToggleGroup toggleGroup = new ToggleGroup();
		
		RadioMenuItem easy = new RadioMenuItem("Easy");
		RadioMenuItem medium = new RadioMenuItem("Medium");
		RadioMenuItem hard = new RadioMenuItem("Hard");
		
		// group all the radio menu items 
		easy.setToggleGroup(toggleGroup);
		medium.setToggleGroup(toggleGroup);
		hard.setToggleGroup(toggleGroup);
		
		difficultyMenu.getItems().addAll(easy, medium, hard);
		
		// Menu bar
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu, difficultyMenu);
		
		// set the layout
		BorderPane borderPane = new BorderPane();
		borderPane.setTop(menuBar);
		
		// set the scene
		this.scene = new Scene(borderPane, this.width, this.height);
		//this.scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		this.window.setScene(this.scene);
		this.window.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
