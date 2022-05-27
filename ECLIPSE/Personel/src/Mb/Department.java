package Mb;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped

/**
 * @author 
 * @version 1.0
 */
public class Department {
	
	//Variablen
	String name;
	int manager;
	String location;
	String message;
	
	//leerer Konstruktor
	public Department() {
		// TODO Auto-generated constructor stub
	}

	//getter-/setter-Methoden
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
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	//weitere Methoden
	/**
	 * Fügt einen neues Department (Abteilung) in die Datenbank ein.
	 * @param 
	 */
	public String addDepartment() {
		dao.Department departmentDao = new dao.Department();
		
		EJB.Department departmentObj = new EJB.Department();
		departmentObj.setName(this.name);
		departmentObj.setManager(this.manager);
		departmentObj.setLocation(this.location);
		
		
		if(departmentDao.checkManagerExists(manager)) {
			this.message = "Manager already Occupied";
		}else {
			int is_inserted = departmentDao.insertDepartment(departmentObj);
			
			int is_manager_updated = departmentDao.UpdateManagerDepartment(is_inserted, this.manager);
			
			this.message = is_inserted > 0 ? "Department Added Successfully" : "Department Couldn't be Added"; //besser als: if(is_inserted > 0) {this.message = "Employee Inserted Successfully";	}else{ this.message = "Employee Couldn't be inserted"; };
		}
		return "admin_addemployee";
	}
}
