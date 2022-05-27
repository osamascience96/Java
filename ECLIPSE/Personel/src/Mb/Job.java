package Mb;


import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 * @author 
 * @version 1.0
 */
@ManagedBean
@javax.faces.bean.RequestScoped
public class Job {
	
	//Variablen
	String designation;
	int working_weekly_hours;
	String joining_date;
	String message;
	
	//leerer Konstruktor
	public Job() {
		// TODO Auto-generated constructor stub
	}

	//getter-/setter-Methoden
	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getWorking_weekly_hours() {
		return working_weekly_hours;
	}

	public void setWorking_weekly_hours(int working_weekly_hours) {
		this.working_weekly_hours = working_weekly_hours;
	}

	public String getJoining_date() {
		return joining_date;
	}

	public void setJoining_date(String joining_date) {
		this.joining_date = joining_date;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Fügt einen neuen Job (Stelle) in die Datenbank ein.
	 * @param 
	 */
	public String addJob() {
		dao.Job jobDAO = new dao.Job();
		
		EJB.Job jobObj = new EJB.Job();
		jobObj.setDesignation(this.designation);
		jobObj.setWeeklyWorkingHours(this.working_weekly_hours);
		
		int exists = jobDAO.insertJob(jobObj);
		
		this.message = exists > 0 ? "New Job Added Successfully" : "Job Couldn't be added";
		
		return "admin_addemployee";
	}
}
