package Mb;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import EJB.Department;
import EJB.Employee;
import EJB.Job;

@ManagedBean
@ApplicationScoped

/**
 * @author 
 * @version 1.0
 */
public class User {
	
	//Variablen
	String username;
	String password;
	String message;
	String user_type;
	String auth;
	boolean is_login;
	Employee employee;
	Department department;
	Job job;
	ArrayList<Employee> employeeArrayList;
	ArrayList<Department> departmentArrayList;
	ArrayList<Job> jobsArrayList;
	ArrayList<Employee> managerArrayList;
	
	// Leerer Konstruktor der Bean
	public User() {
		// TODO Auto-generated constructor stub
	}
 
	// Getter- & Setter-Methoden
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public Employee getEmployee() {
		return employee;
	}

	public boolean isIs_login() {
		return is_login;
	}

	public void setIs_login(boolean is_login) {
		this.is_login = is_login;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public ArrayList<Employee> getEmployeeArrayList() {
		return employeeArrayList;
	}

	public void setEmployeeArrayList(ArrayList<Employee> employeeArrayList) {
		this.employeeArrayList = employeeArrayList;
	}

	public ArrayList<Department> getDepartmentArrayList() {
		return departmentArrayList;
	}

	public void setDepartmentArrayList(ArrayList<Department> departmentArrayList) {
		this.departmentArrayList = departmentArrayList;
	}

	public ArrayList<Job> getJobsArrayList() {
		return jobsArrayList;
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	public void setJobsArrayList(ArrayList<Job> jobsArrayList) {
		this.jobsArrayList = jobsArrayList;
	}

	public ArrayList<Employee> getManagerArrayList() {
		return managerArrayList;
	}

	public void setManagerArrayList(ArrayList<Employee> managerArrayList) {
		this.managerArrayList = managerArrayList;
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
	
	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	/**
	 * Login-Methode für den Login-Button.
	 * Überprüft die Anmeldedaten und leiter je nach Benutzergruppe auf die nächste Seite.
	 * @param 
	 */
	public String login() {
		
		String link = "";
		
		// Erstellt Objekte der dao-Klassen
		dao.Employee employeeObj = new dao.Employee();
		dao.Department departmentObj = new dao.Department();
		dao.Job jobObj = new dao.Job();
		
		// getEmployee = erstellt ein Employee-Objekt der EJB Klasse und speichert die Daten in den employee dieser Klasse
		this.employee = employeeObj.getEmployee(this.username, this.password);
		
		// Falsche oder nicht vorhandene Anmeldedaten
		if(employee == null) {
			this.message = "Invalid Credentials Entered";
			link = "login";
		}else {					
			this.is_login = true;	// to check the login state at the navigation
			
			// Hole alle Employees, Departments, Jobs & Managers (aus DB)
			this.employeeArrayList = employeeObj.getAllEmployeeList();
			this.departmentArrayList = departmentObj.getAllDepartmentList();
			this.jobsArrayList = jobObj.getAllJobList();
			this.managerArrayList = employeeObj.getAllManagers();
			
			//Als Manager anmelden		//-ganzZ = davor; +ganzZ = danach; 0 = gleich
			if(employee.getAuth().compareTo("manager") == 0) {
				this.message = "Welcome HR Manager";
				this.user_type = "hr_manager";
				link = "admin";
				
			//Als Employee anmelden
			}else if(employee.getAuth().compareTo("employee") == 0){
				this.user_type = "hr_employee";
				
				this.message = "Welcome HR Employee";
				link = "admin";
			}
		}
		// Link zu welcher Seite
		return link;
	}	
	
	/**
	 * Zeigt das Department (Abteilung) des jeweiligen Mitarbeiters an.
	 * @param id int
	 */
	public String viewDept(int id) {
		dao.Department deptDAO = new dao.Department();
		this.department = deptDAO.getDepartment(id);
		return "view_dept";
	}
	
	/**
	 * Zeigt den Job (Stelle) des jeweiligen Mitarbeiters an.
	 * @param id int
	 */
	public String viewJob(int id) {
		dao.Job jobDAO = new dao.Job();
		this.job = jobDAO.getJob(id);
		return "view_job";
	}
	
	/**
	 * Löscht den jeweiligen Mitarbeiter aus der Tabelle und aus der Datenbank.
	 * @param id int
	 */
	public void deleteEmployee(int id) {
		dao.Employee employeeDAO = new dao.Employee();
		employeeDAO.deleteEmployee(id);
		//holt die aktuellen, geänderten informationen & updatet die Session
		login();
	}
	
	/**
	 * Logt den Benutzer aus und bringt ihn somit wieder aus die Lgin-Seite.
	 * @param 
	 */
	public String logout() {
		this.message = null;
		this.is_login = false;
		this.employee = null;
		return "index";
	}
}
