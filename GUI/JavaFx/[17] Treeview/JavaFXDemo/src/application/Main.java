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
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application{
	
	private Stage window;
	private Scene scene;
	private TreeView<String> treeView;
	private Button button;
	
	private int width = 300;
	private int height = 300;
	
	@Override
	public void start(Stage primaryStage) {
		this.window = primaryStage;
		this.window.setTitle("Select Prophet Hirarchey");
		this.button = new Button("See Prophet Hirarchey");
		
		Button buttonProphetPartiarchLine = new Button("See Prophet Patriarch Line");
		
		TreeItem<String> ibrahimRoot, ismaelBranch, ishaqBranch, israelBranch;
		
		ibrahimRoot = new TreeItem<String>("Prophet Ibrahim");
		ibrahimRoot.setExpanded(true);
		
		ismaelBranch = this.solveBranch("Prophet Ismaeel", ibrahimRoot);
		this.solveBranch("Prophet Muhammad", ismaelBranch);
		
		ishaqBranch = this.solveBranch("Prophet Ishaq", ibrahimRoot);
		
		israelBranch = this.solveBranch("Prophet Yaqoob", ishaqBranch);
		this.solveBranch("Prophet Yousuf", israelBranch);
		this.solveBranch("Prophet Musa", israelBranch);
		this.solveBranch("Prophet Zakariya", israelBranch);
		this.solveBranch("Prophet Imran", israelBranch);
		this.solveBranch("Prophet Isayah", israelBranch);
		this.solveBranch("Prophet Isa", israelBranch);
		
		// set the tree view
		this.treeView = new TreeView<String>(ibrahimRoot);
		
		// on click on any prophet name, show the name only
		this.treeView.getSelectionModel().selectedItemProperty().addListener((observable, oldval, newval) -> System.out.println("\nYou clicked on the name of " + newval.getValue()));
		
		// on button click
		this.button.setOnAction(e -> this.ShowHirarcheyofProphet(this.treeView.getSelectionModel().getSelectedItem()));
		buttonProphetPartiarchLine.setOnAction(e -> this.ShowPatriarchLine(this.treeView.getSelectionModel().getSelectedItem()));
		// set the layout
		VBox vBoxLayout = new VBox(10);
		vBoxLayout.setPadding(new Insets(20, 20, 20, 20));
		vBoxLayout.getChildren().addAll(this.treeView, this.button, buttonProphetPartiarchLine);
		
		// set the scene
		this.scene = new Scene(vBoxLayout, this.width, this.height);
		//this.scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		this.window.setScene(this.scene);
		this.window.show();
	}
	
	// This function will work in linear fashion
	private void ShowHirarcheyofProphet(TreeItem<String> prophetTreeItem) {
		TreeItem<String> letStartLeaf = prophetTreeItem;
		while(letStartLeaf != null) {
			System.out.print(letStartLeaf.getValue().concat(letStartLeaf.getParent() != null ? " bin " : ""));
			letStartLeaf = letStartLeaf.getParent();
		}
		
		System.out.println();
	}
	
	// This function will work in the recursive fashion
	private void ShowPatriarchLine(TreeItem<String> prophetTreeItem){
		TreeItem<String> letStartLeaf = prophetTreeItem;
		// if the node has the parent
		if(letStartLeaf.getParent() != null) {
			ShowPatriarchLine(letStartLeaf.getParent());
		}
		
		System.out.print(letStartLeaf.getValue().concat(letStartLeaf.getChildren().size() > 0 ? " is the patriarch of " : "\n"));
	}
	
	private TreeItem<String> solveBranch(String title, TreeItem<String> parent){
		TreeItem<String> treeItem = new TreeItem<String>(title);
		parent.getChildren().add(treeItem);
		return treeItem;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
