package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {
	private StringProperty firstName = new SimpleStringProperty(this, "firstName", "");
	
	// Returns the String Property Object
	public StringProperty firstNameProperty() {
		return firstName;
	}
	
	// returns the firstname value 
	public String getFirstName() {
		return this.firstName.get();
	}
	
	public void setFirstName(String firstName) {
		this.firstName.set(firstName);
	}
}
