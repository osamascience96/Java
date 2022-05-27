package bean;

public class Course {
	private int id;
	private String name;
	private String grades;
	
	public Course() {
	}
	
	public Course(int id, String name, String grades) {
		this.id = id;
		this.name = name;
		this.grades = grades;
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

	public String getGrades() {
		return grades;
	}

	public void setGrades(String grades) {
		this.grades = grades;
	}
	
	
}
