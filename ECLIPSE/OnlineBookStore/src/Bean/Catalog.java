package Bean;

public class Catalog {
	private int id;
	private String name;
	private String description;
	private double price;
	private String created_at;
	
	public Catalog() {
	}
	
	public Catalog(int id, String name, String description, double price, String created_at) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.created_at = created_at;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	
	
}
