package EJB;

/**
 * Support-Objekts that store the data. own EJB. 
 * @author 
 * @version 1.0
 */
public class Employee {
	
	private int id;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String auth;
	private String email;
	private String password;
	private String phone;
	private Department department;
	private Job job;
	private double salary;
	private String createdAt;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Benutzerdefinierter Konstruktor für die Klasse Employee.
	 * @param id int, firstName String, lastName String, dateOfBirth String, email String, password String, phone String, auth String, department Department, job Job, salary double, createdAt String
	 */
	public Employee(int id, String firstName, String lastName, String dateOfBirth, String email, String password, String phone, String auth,
			Department department, Job job, double salary, String createdAt) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.auth = auth;
		this.department = department;
		this.job = job;
		this.salary = salary;
		this.createdAt = createdAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public double getSalary() {
		return salary;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public double getsalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	
	
}
