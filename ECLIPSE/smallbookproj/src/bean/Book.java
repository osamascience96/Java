package bean;

public class Book {
	private int id;
	private Author author;
	private String name;
	private double price;
	private String created_at;
	
	public Book() {
	}

	public Book(int id, Author author, String name, double price, String created_at) {
		super();
		this.id = id;
		this.author = author;
		this.name = name;
		this.price = price;
		this.created_at = created_at;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
