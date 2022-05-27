package computer;

public class Computer {
	private String manufacturersName;
	private double price;
	
	public Computer() {
		
	}
	
	public Computer(String manufacturersName, double price) {
		this.manufacturersName = manufacturersName;
		this.price = price;
	}

	public String getManufacturersName() {
		return manufacturersName;
	}

	public void setManufacturersName(String manufacturersName) {
		this.manufacturersName = manufacturersName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	public void outputComputerDetails() {
		System.out.println("Manufacturers Name: " + this.manufacturersName);
		System.out.println("Price: $" + this.price);
	}
}
