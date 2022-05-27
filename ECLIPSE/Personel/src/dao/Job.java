package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import database.Connect;

/**
 * Ist mit der Datenbank verbunden und stellt Methoden zur Verfügung, mit denen durch SQL-Abfragen Daten aus der Datenbank aberufen werden können.
 * Die Methoden beziehen sich in dieser Klasse auf die Abfrage und Befehle von der Tabelle Job.
 * @author 
 * @version 1.0
 */
public class Job {
	private Connection connection;
	
	public Job() {
		// TODO Auto-generated constructor stub
		this.connection = Connect.getConnectionInstance().getConnection();
	}
	
	/**
	 * Gibt alle in der Datenbank gespeicherten Jobs (Stellen) zurück, durch eine SQL-Abfrage.
	 * @param 
	 */
	public ArrayList<EJB.Job> getAllJobList(){
		ArrayList<EJB.Job> jobArrayList = new ArrayList<EJB.Job>();
		
		String query = "SELECT * FROM jobs";
		try {
			PreparedStatement pstmt = this.connection.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				jobArrayList.add(new EJB.Job(rs.getInt("id"), rs.getString("designation"), rs.getInt("weekly_working_hours"), rs.getString("created_at")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jobArrayList;
	}
	
	/**
	 * Gibt anhand der eingegebenen Job id, den dazugehörigen Job mit allen dazugehörigen Attributen zurück. (durch eine SQL-Abfrage)
	 * @param id int
	 */
	public EJB.Job getJob(int id){
		EJB.Job job = null;
		
		String query = "SELECT * FROM jobs WHERE id = ?";
		try {
			PreparedStatement pstmt = this.connection.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				job = new EJB.Job(rs.getInt("id"), rs.getString("designation"), rs.getInt("weekly_working_hours"), rs.getString("created_at"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return job;
	}
	
	/**
	 * Fügt in der Datenbank, in die Tabelle "Job" einen neuen Eintrag hinzu. (durch einen SQL-Befehl)
	 * @param job EJB.Job
	 */
	public int insertJob(EJB.Job job) {
		int exists = 0;
		
		String query = "INSERT INTO jobs(designation, weekly_working_hours) VALUES(?, ?)";
		
		try {
			PreparedStatement pstmt = this.connection.prepareStatement(query);
			pstmt.setString(1, job.getDesignation());
			pstmt.setInt(2, job.getWeeklyWorkingHours());
			exists = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return exists;
	}
}
