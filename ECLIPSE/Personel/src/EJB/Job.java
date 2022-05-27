package EJB;

/**
 * 
 * @author 
 * @version 1.0
 */
public class Job {
	
	private int id;
	private String designation;
	private int weeklyWorkingHours;
	private String createdAt;
	
	public Job() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Benutzerdefinierter Konstruktor für die Klasse Job.
	 * @param id int, designation String, weeklyWorkingHours int, joining_date String, createdAt String
	 */
	public Job(int id, String designation, int weeklyWorkingHours, String createdAt) {
		this.id = id;
		this.designation = designation;
		this.weeklyWorkingHours = weeklyWorkingHours;
		this.createdAt = createdAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getWeeklyWorkingHours() {
		return weeklyWorkingHours;
	}

	public void setWeeklyWorkingHours(int weeklyWorkingHours) {
		this.weeklyWorkingHours = weeklyWorkingHours;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	
	
}
