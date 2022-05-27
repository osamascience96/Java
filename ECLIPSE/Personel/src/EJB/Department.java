package EJB;

/**
 * 
 * @author 
 * @version 1.0
 */
public class Department {
	
	private int id;
	private String name;
	private int manager;
	private String managername;
	private String location;
	private String createdAt;
	
	public Department() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Benutzerdefinierter Konstruktor für die Klasse Department.
	 * @param id int, name String, manager String, location String, createdAt String
	 */
	public Department(int id, String name, int manager, String location, String createdAt) { //, String manager
		super(); //Warum????   // Um Parent-Konstruktor, -Methoden, -Eigenschaften zu nutzen
		this.id = id;
		this.name = name;
		this.manager = manager;
		this.location = location;
		this.createdAt = createdAt;
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
	
	public int getManager() {
		return manager;
	}

	public void setManager(int manager) {
		this.manager = manager;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getManagername() {
		return managername;
	}

	public void setManagername(String managername) {
		this.managername = managername;
	}
	
	
}
