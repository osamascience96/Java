package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.Connect;

public class Doctor {
	private Connection connection;
	
	public Doctor() {
		this.connection = Connect.getConnectionInstance().getConnection();
	}
	
	public ArrayList<bean.Doctor> GetDoctorArrayList() throws SQLException{
		ArrayList<bean.Doctor> arrayListDoctors = new ArrayList<bean.Doctor>();
		
		String query = "SELECT doctors.*, users.username, users.password, users.usertype FROM doctors JOIN users ON doctors.user_id = users.id";
		
		PreparedStatement pstmt = this.connection.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			arrayListDoctors.add(new bean.Doctor(rs.getInt("id"), rs.getInt("user_id"), rs.getString("username"), rs.getString("email"), rs.getString("password"), rs.getString("usertype"), rs.getString("name"), rs.getInt("age"), rs.getBlob("image"), rs.getString("phone"), rs.getString("qualification"), rs.getInt("Availability"), rs.getString("cures"), rs.getString("national_id_card"), rs.getInt("approved"), rs.getString("created_at")));
		}
		
		return arrayListDoctors;
	}
	
	public bean.Doctor GetDoctorObj(int userId) throws SQLException{
		bean.Doctor doctorObj = null;
		
		String query = "SELECT doctors.*, users.username, users.password, users.usertype FROM doctors JOIN users ON doctors.user_id = users.id WHERE doctors.user_id = ?";
		
		PreparedStatement pstmt = this.connection.prepareStatement(query);
		pstmt.setInt(1, userId);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			doctorObj = new bean.Doctor(rs.getInt("id"), rs.getInt("user_id"), rs.getString("username"), rs.getString("email"), rs.getString("password"), rs.getString("usertype"), rs.getString("name"), rs.getInt("age"), rs.getBlob("image"), rs.getString("phone"), rs.getString("qualification"), rs.getInt("Availability"), rs.getString("cures"), rs.getString("national_id_card"), rs.getInt("approved"), rs.getString("created_at"));
		}
		
		return doctorObj;
	}
	
	public void InsertDoctor(bean.Doctor doctor) throws SQLException {
		String query = "INSERT INTO doctors(user_id, name, age, image, phone, email, qualification, cures, national_id_card) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement pstmt = this.connection.prepareStatement(query);
		pstmt.setInt(1, doctor.getUserId());
		pstmt.setString(2, doctor.getName());
		pstmt.setInt(3, doctor.getAge());
		pstmt.setBlob(4, doctor.GetInputStream());
		pstmt.setString(5, doctor.getPhone());
		pstmt.setString(6, doctor.getEmail());
		pstmt.setString(7, doctor.getQualification());
		pstmt.setString(8, doctor.getCures());
		pstmt.setString(9, doctor.getNid());
		
		pstmt.executeUpdate();
	}
	
	public void UpdateDoctortoActive(int doctorId) throws SQLException {
		String query = "UPDATE doctors SET approved = 1 WHERE id = ?";
		
		PreparedStatement pstmt = this.connection.prepareStatement(query);
		pstmt.setInt(1, doctorId);
		pstmt.executeUpdate();
	}
	
	public void UpdateDoctortoDeactive(int doctorId) throws SQLException{
		String query = "UPDATE doctors SET approved = 0 WHERE id = ?";
		
		PreparedStatement pstmt = this.connection.prepareStatement(query);
		pstmt.setInt(1, doctorId);
		pstmt.executeUpdate();
	}
	
	public void UpdateDoctorAvailibilityOn(int doctorId) throws SQLException{
		String query = "UPDATE doctors SET Availability = 1 WHERE id = ?";
		
		PreparedStatement pstmt = this.connection.prepareStatement(query);
		pstmt.setInt(1, doctorId);
		pstmt.executeUpdate();
	}
	
	public void UpdateDoctorAvailibilityOff(int doctorId) throws SQLException{
		String query = "UPDATE doctors SET Availability = 0 WHERE id = ?";
		
		PreparedStatement pstmt = this.connection.prepareStatement(query);
		pstmt.setInt(1, doctorId);
		pstmt.executeUpdate();
	}
}
