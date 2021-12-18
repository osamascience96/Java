package application;

import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application{
	
	private Stage window;
	private Scene scene;
	
	private int width = 500;
	private int height = 300;
	
	@Override
	public void start(Stage primaryStage) {
		this.window = primaryStage;
		this.window.setTitle("Inventory");
		
		TableView<Product> tableView = new TableView<Product>();
		
		// Name Column
		TableColumn<Product, String> nameColumn = new TableColumn<>("Name");
		nameColumn.setMinWidth(200);
		nameColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getName()));
		
		// Quantity Column
		TableColumn<Product, Integer> quantityColumn = new TableColumn<>("Quantity");
		quantityColumn.setMinWidth(200);
		quantityColumn.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getQuantity()).asObject());
		
		// Price Column
		TableColumn<Product, Double> priceColumn = new TableColumn<>("Price");
		priceColumn.setMinWidth(200);
		priceColumn.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getPrice()).asObject());
		
		tableView.setItems(this.getProduct());
		tableView.getColumns().addAll(nameColumn, priceColumn, quantityColumn);
		
		// set the layout
		VBox vBoxLayout = new VBox(10);
		vBoxLayout.setPadding(new Insets(20, 20, 20, 20));
		vBoxLayout.getChildren().addAll(tableView);
		
		// set the scene
		this.scene = new Scene(vBoxLayout, this.width, this.height);
		//this.scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		this.window.setScene(this.scene);
		this.window.show();
	}
	
	//Get all the products
	private ObservableList<Product> getProduct(){
		ObservableList<Product> observableList = FXCollections.observableArrayList();
		observableList.add(new Product("Laptop", 20, 120.50));
		observableList.add(new Product("Docking Station", 50, 99.50));
		observableList.add(new Product("Playstation", 100, 150.80));
		observableList.add(new Product("Google Pixel", 25, 80.32));
		return observableList;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
