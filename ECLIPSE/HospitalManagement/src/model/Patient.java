package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.Connect;

public class Patient {
	private Connection connection;
	
	public Patient() {
		this.connection = Connect.getConnectionInstance().getConnection();
	}
	
	public ArrayList<bean.Patient> GetPatientList() throws SQLException{
		ArrayList<bean.Patient> patientArrayList = new ArrayList<bean.Patient>();
		
		String query = "SELECT patients.*, users.username, users.password, users.usertype FROM patients JOIN users ON patients.user_id = users.id";
		
		PreparedStatement pstmt = this.connection.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			patientArrayList.add(new bean.Patient(rs.getInt("id"), rs.getInt("user_id"), rs.getString("username"), rs.getString("email"), rs.getString("password"), rs.getString("usertype"), rs.getString("name"), rs.getInt("age"), rs.getBlob("image"), rs.getString("phone"), rs.getString("national_id_card"), rs.getString("created_at")));
		}
		
		return patientArrayList;
	}
	
	public ArrayList<bean.Patient> GetPatientSystemList() throws SQLException{
		ArrayList<bean.Patient> patientArrayList = new ArrayList<bean.Patient>();
		
		String query = "SELECT patients.*, users.username, users.password, users.usertype FROM patients JOIN users ON patients.user_id = users.id WHERE patients.user_id != 1";
		
		PreparedStatement pstmt = this.connection.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			patientArrayList.add(new bean.Patient(rs.getInt("id"), rs.getInt("user_id"), rs.getString("username"), rs.getString("email"), rs.getString("password"), rs.getString("usertype"), rs.getString("name"), rs.getInt("age"), rs.getBlob("image"), rs.getString("phone"), rs.getString("national_id_card"), rs.getString("created_at")));
		}
		
		return patientArrayList;
	}
	
	public ArrayList<bean.Patient> GetPatientAnnonymousList() throws SQLException{
		ArrayList<bean.Patient> patientArrayList = new ArrayList<bean.Patient>();
		
		String query = "SELECT patients.*, users.username, users.password, users.usertype FROM patients JOIN users ON patients.user_id = users.id WHERE patients.user_id = 1";
		
		PreparedStatement pstmt = this.connection.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			patientArrayList.add(new bean.Patient(rs.getInt("id"), rs.getInt("user_id"), rs.getString("username"), rs.getString("email"), rs.getString("password"), rs.getString("usertype"), rs.getString("name"), rs.getInt("age"), rs.getBlob("image"), rs.getString("phone"), rs.getString("national_id_card"), rs.getString("created_at")));
		}
		
		return patientArrayList;
	}
	
	public bean.Patient GetPatientObj(int userId) throws SQLException{
		bean.Patient patientObj = null;
		
		String query = "SELECT patients.*, users.username, users.password, users.usertype FROM patients JOIN users ON patients.user_id = users.id WHERE patients.user_id = ?";
		PreparedStatement pstmt = this.connection.prepareStatement(query);
		pstmt.setInt(1, userId);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			patientObj = new bean.Patient(rs.getInt("id"), rs.getInt("user_id"), rs.getString("username"), rs.getString("email"), rs.getString("password"), rs.getString("usertype"), rs.getString("name"), rs.getInt("age"), rs.getBlob("image"), rs.getString("phone"), rs.getString("national_id_card"), rs.getString("created_at"));
					
		}
		
		return patientObj;
	}
	
	public void InsertPatient(bean.Patient patient) throws SQLException {
		String query = "INSERT into patients(user_id, name, age, image, phone, email, national_id_card) VALUES(?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement pstmt = this.connection.prepareStatement(query);
		pstmt.setInt(1, patient.getUserId());
		pstmt.setString(2, patient.getName());
		pstmt.setInt(3, patient.getAge());
		pstmt.setBlob(4, patient.getIs());
		pstmt.setString(5, patient.getPhone());
		pstmt.setString(6, patient.getEmail());
		pstmt.setString(7, patient.getNid());
		
		pstmt.executeUpdate();
	}
}
