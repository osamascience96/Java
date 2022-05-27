package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import EJB.Department;
import EJB.Job;
import database.Connect;

/**
 * Ist mit der Datenbank verbunden und stellt Methoden zur Verfügung, mit denen durch SQL-Abfragen Daten aus der Datenbank aberufen werden können.
 * Die Methoden beziehen sich in dieser Klasse auf die Abfrage und Befehle von der Tabelle Employee.
 * @author 
 * @version 1.0
 */
public class Employee {
	private Connection connection;
	
	public Employee() {
		// TODO Auto-generated constructor stub
		// holt Verbindungsinstanz und SQL-Instanz
		this.connection = Connect.getConnectionInstance().getConnection();
	}
	
	/**
	 * Prüft anhand einer eingegebenen email, ob in der Datenbank (Tabelle: Employees) bereits ein Datensatz mit der gleichen email vorhanden ist.
	 * Falls dies der Fall ist, wird ein true zurückgegeben.
	 * @param email String
	 */
	public boolean checkEmployeeExists(String email) {
		boolean exists = false;
		
		// SQL query in variable gespeichert
		String query = "SELECT * FROM employees WHERE email = ?";
		try {
			// SQL query in PS gespeichert
			PreparedStatement pstmt = this.connection.prepareStatement(query);
			// Fügt gewünschten Wert (hier: email) im ersten Platzhalter ein
			pstmt.setString(1, email);
			// Query wird ausgeführt & in RS gespeichert
			ResultSet rs = pstmt.executeQuery();
			
			// iteriert die Zeilen
			if(rs.next()) {
				exists = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return exists;
	}
	
	/**
	 * Gibt anhand der eingegebenen email und dem eingegebenen password, den dazugehörigen Employee mit allen dazugehörigen Attributen zurück. (durch eine SQL-Abfrage)
	 * @param password String, email String
	 */
	public EJB.Employee getEmployee(String email, String password) {
		EJB.Employee employee = null;
																// Aliasse um unten abzurufen
		String query = "SELECT employees.*, departments.name as department_name, departments.location as deptLocation, jobs.designation as jobDesignation, jobs.weekly_working_hours as workingHrs, jobs.created_at as jobs_created_at FROM `employees` LEFT JOIN departments ON departments.id = employees.department_no LEFT JOIN jobs ON jobs.id = employees.job_id WHERE employees.email = ? AND employees.password = ?";
		try {
			PreparedStatement pstmt = this.connection.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			
			// Wenn sich für die Datensatz ein Datensatz befindet, iteriere durch die ausgewählten Zeilen und erstelle zu Department, Job & Employee Objekte 	
			if(rs.next()) {
				Department department = new Department();
				department.setId(rs.getInt("department_no"));
				department.setName(rs.getString("department_name"));
				department.setLocation(rs.getString("deptLocation"));
				
				Job job = new Job();
				job.setDesignation(rs.getString("jobDesignation"));
				job.setWeeklyWorkingHours(rs.getInt("workingHrs"));
				job.setCreatedAt(rs.getString("jobs_created_at"));
				
				employee = new EJB.Employee(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("date_of_birth"), rs.getString("email"), rs.getString("password"), rs.getString("phone"), rs.getString("auth"), department, job, rs.getDouble("salary"), rs.getString("created_at"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return employee;
	}
	
	/**
	 * Gibt alle in der Datenbank gespeicherten Employee (Mtarbeiter) zurück, durch eine SQL-Abfrage.
	 * @param 
	 */
	public ArrayList<EJB.Employee> getAllEmployeeList(){
		ArrayList<EJB.Employee> employeeArrayList = new ArrayList<EJB.Employee>();
		
		String query = "SELECT employees.*, departments.name as department_name, departments.location as deptLocation, jobs.designation as jobDesignation, jobs.weekly_working_hours as workingHrs, jobs.created_at as jobs_created_at FROM `employees` LEFT JOIN departments ON departments.id = employees.department_no LEFT JOIN jobs ON jobs.id = employees.job_id";
		
		try {
			PreparedStatement pstmt = this.connection.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Department department = new Department();
				department.setId(rs.getInt("department_no"));
				department.setName(rs.getString("department_name"));
				department.setLocation(rs.getString("deptLocation"));
				
				Job job = new Job();
				job.setId(rs.getInt("job_id"));
				job.setDesignation(rs.getString("jobDesignation"));
				job.setWeeklyWorkingHours(rs.getInt("workingHrs"));
				job.setCreatedAt(rs.getString("jobs_created_at"));
				
				employeeArrayList.add(new EJB.Employee(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("date_of_birth"), rs.getString("email"), rs.getString("password"), rs.getString("phone"), rs.getString("auth"), department, job, rs.getDouble("salary"), rs.getString("created_at")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return employeeArrayList;
	}
	
	public ArrayList<EJB.Employee> getAllManagers(){
		ArrayList<EJB.Employee> employeeArrayList = new ArrayList<EJB.Employee>();
		
		String query = "SELECT * FROM employees WHERE auth = 'manager'";
		
		PreparedStatement psmt;
		try {
			psmt = this.connection.prepareStatement(query);
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {
				EJB.Employee employee = new EJB.Employee();
				employee.setId(rs.getInt("id"));
				employee.setFirstName(rs.getString("first_name"));
				
				employeeArrayList.add(employee);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return employeeArrayList;

	}
	
	/**
	 * Fügt in der Datenbank, in die Tabelle "Employee" einen neuen Eintrag hinzu. (durch einen SQL-Befehl)
	 * @param employee Employee
	 */
	public int insertEmployee(EJB.Employee employee) {
		String query = "INSERT INTO employees(first_name, last_name, date_of_birth, email, password, phone, salary, department_no, job_id, auth) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		int is_inserted = 0;
		
		try {
			PreparedStatement pstmt = this.connection.prepareStatement(query);
			pstmt.setString(1, employee.getFirstName());
			pstmt.setString(2, employee.getLastName());
			pstmt.setString(3, employee.getDateOfBirth());
			pstmt.setString(4, employee.getEmail());
			pstmt.setString(5, employee.getPassword());
			pstmt.setString(6, employee.getPhone());
			pstmt.setDouble(7, employee.getsalary());
			pstmt.setInt(8, employee.getDepartment().getId());
			pstmt.setInt(9, employee.getJob().getId());
			pstmt.setString(10, employee.getAuth());
			is_inserted = pstmt.executeUpdate();	//gibt entweder (1) die Zeilenzahl für SQL-DML-Anweisungen zurück oder (2) 0 für SQL-Anweisungen, die nichts zurückgeben
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return is_inserted;
	}
	
	/**
	 * Löscht den zu der eingegebenen id passenden Employee aus der Datenbank heraus.
	 * @param id int
	 */
	public void deleteEmployee(int id) {
		String query = "DELETE FROM employees WHERE id = ?";
		
		PreparedStatement pstmt;
		try {
			pstmt = this.connection.prepareStatement(query);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
