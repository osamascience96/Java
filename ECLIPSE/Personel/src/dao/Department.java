package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.Connect;

/**
 * Ist mit der Datenbank verbunden und stellt Methoden zur Verfügung, mit denen durch SQL-Abfragen Daten aus der Datenbank aberufen werden können.
 * Die Methoden beziehen sich in dieser Klasse auf die Abfrage und Befehle von der Tabelle Department.
 * @author 
 * @version 1.0
 */
public class Department {
	private Connection connection;
	
	public Department() {
		// TODO Auto-generated constructor stub
		this.connection = Connect.getConnectionInstance().getConnection();
	}
	
	/**
	 * Gibt alle in der Datenbank gespeicherten Departments (Abteilungen) zurück, durch eine SQL-Abfrage.
	 * @param 
	 */
	
	public boolean checkManagerExists(int manager_id) {
		boolean is_exists = false;
		
		String query = "SELECT * FROM departments WHERE manager_id = ?";
		
		try {
			PreparedStatement pstmt = this.connection.prepareStatement(query);
			pstmt.setInt(1, manager_id);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				is_exists = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return is_exists;
		
	}
	
	public ArrayList<EJB.Department> getAllDepartmentList(){
		ArrayList<EJB.Department> departmentArrayList = new ArrayList<EJB.Department>();
		
		String query = "SELECT * FROM departments";
		
		try {
			PreparedStatement pstmt = this.connection.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				departmentArrayList.add(new EJB.Department(rs.getInt("id"), rs.getString("name"), rs.getInt("manager_id"), rs.getString("location"), rs.getString("created_at")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return departmentArrayList;
	}
	
	/**
	 * Gibt anhand der eingegebenen Department id, das dazugehörige Department mit allen dazugehörigen Attributen zurück. (durch eine SQL-Abfrage)
	 * @param id int
	 */
	public EJB.Department getDepartment(int id){
		EJB.Department department = null;
		
		String query = "SELECT departments.*, employees.first_name as manager_name FROM `departments` JOIN employees ON departments.manager_id = employees.id WHERE departments.id = ?";
		
		PreparedStatement pstmt;
		try {
			pstmt = this.connection.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				department = new EJB.Department(rs.getInt("id"), rs.getString("name"), rs.getInt("manager_id"), rs.getString("location"), rs.getString("created_at"));
				department.setManagername(rs.getString("manager_name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return department;
	}
	
	/**
	 * Fügt in der Datenbank, in die Tabelle "Department" einen neuen Eintrag hinzu. (durch einen SQL-Befehl)
	 * @param department EJB.Department
	 */
	public int insertDepartment(EJB.Department department) {
		int inserted = 0;
		String query = "INSERT INTO departments(name, manager_id, location) VALUES (?, ?, ?)";
		
		PreparedStatement pstmt;
		try {
			pstmt = this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, department.getName());
			pstmt.setInt(2, department.getManager());
			pstmt.setString(3, department.getLocation());
			inserted = pstmt.executeUpdate();	
			
			// return the id of the new row inserted
			ResultSet rs = pstmt.getGeneratedKeys();
			
			if(rs.next()) {
				inserted = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return inserted;
	}
	
	public int UpdateManagerDepartment(int deptId, int  employeeId) {
		int is_update = 0;
		
		String query = "UPDATE employees SET department_no = ? WHERE id = ?";
		
		try {
			PreparedStatement pstmt = this.connection.prepareStatement(query);
			pstmt.setInt(1, deptId);
			pstmt.setInt(2, employeeId);
			
			is_update = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return is_update;
	}
}
