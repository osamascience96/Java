package Mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import EJB.Department;
import EJB.Job;

/**xx
 * @author 
 * @version 1.0
 */
@ManagedBean
@RequestScoped
public class Employee {
	
	//Variablen
	String firstName;
	String lastName;
	String dateOfBirth;
	String email;
	String password;
	String phone;
	double salary;
	String auth;
	int departmentId;
	int jobId;
	
	String message;
	
	//leerer Konstruktor
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	//getter-/setter-Methoden
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

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	
	public String getMessage() {
		return message;
	}
	
	

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	//weitere Methoden
	
	/**
	 * Fügt einen neuen Employee (Mitarbeiter) in die Datenbank ein.
	 * Dafür wird ein neues Employee-Objekt erstellt, sowie das dazugehörende Department-Objekt und Job-Objekt.
	 * @param 
	 */
	public String addEmployee() {
		int is_inserted = 0;
		dao.Employee userDAO = new dao.Employee();
		if(userDAO.checkEmployeeExists(this.email)) {
			this.message = "Employee Already Exists";
		}else {
			EJB.Employee employeeObj = new EJB.Employee();
			employeeObj.setFirstName(this.firstName);
			employeeObj.setLastName(this.lastName);
			employeeObj.setDateOfBirth(this.dateOfBirth);
			employeeObj.setEmail(this.email);
			employeeObj.setPhone(this.phone);
			employeeObj.setAuth(this.auth);
			employeeObj.setPassword(this.password);
			employeeObj.setSalary(this.salary);
			
			Department department = new Department();
			department.setId(this.departmentId);
			
			Job job = new Job();
			job.setId(this.jobId);
			
			employeeObj.setDepartment(department);
			employeeObj.setJob(job);
			
			is_inserted = userDAO.insertEmployee(employeeObj);
			this.message = is_inserted > 0 ? "Employee Inserted Successfully" : "Employee Couldn't be inserted";
		}
		
		return "admin_addemployee";
	}
}
