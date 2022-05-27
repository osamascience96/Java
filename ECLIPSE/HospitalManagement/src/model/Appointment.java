package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Doctor;
import bean.Patient;
import database.Connect;

public class Appointment {
	private Connection connection;
	
	public Appointment() {
		this.connection = Connect.getConnectionInstance().getConnection();
	}
	
	public ArrayList<bean.Appointment> GetAppointmentArrayList() throws SQLException{
		ArrayList<bean.Appointment> arrayListAppointment = new ArrayList<bean.Appointment>();
		
		String query = "SELECT patients.id as patientid, patients.name as patientname, doctors.id as doctorid, doctors.name as doctorname, appointments.* FROM appointments LEFT JOIN patients ON patients.id = appointments.patient_id LEFT JOIN doctors ON doctors.id = appointments.doctor_id";
		
		PreparedStatement pstmt = this.connection.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			bean.Appointment appointmentObj = new bean.Appointment(rs.getInt("id"), rs.getInt("patient_id"), rs.getInt("doctor_id"), rs.getString("details"), rs.getString("apointed_date"), rs.getString("status"), rs.getString("created_at"));
			
			bean.Patient patientObj = new Patient();
			patientObj.setId(rs.getInt("patientid"));
			patientObj.setName(rs.getString("patientname"));
			
			bean.Doctor doctorObj = new bean.Doctor();
			doctorObj.setId(rs.getInt("doctorid"));
			doctorObj.setName(rs.getString("doctorname"));
			
			appointmentObj.setPatientObj(patientObj);
			appointmentObj.setDoctorObj(doctorObj);
			
			arrayListAppointment.add(appointmentObj);
		}
		
		return arrayListAppointment;
	}
	
	public void InsertAppointment(bean.Appointment appointment) throws SQLException {
		String query = "INSERT INTO appointments(patient_id, doctor_id, details, apointed_date) VALUES (?, ?, ?, ?)";
		
		PreparedStatement pstmt = this.connection.prepareStatement(query);
		pstmt.setInt(1, appointment.getPatientId());
		pstmt.setInt(2, appointment.getDoctorId());
		pstmt.setString(3, appointment.getDetails());
		pstmt.setString(4, appointment.getAppointedDate());
		
		pstmt.executeUpdate();
	}
	
	public void UpdateAppointmentStatus(int appiontmentId) throws SQLException{
		String query = "UPDATE appointments SET status = 'receieved' WHERE id = ?";
		
		PreparedStatement pstmt = this.connection.prepareStatement(query);
		pstmt.setInt(1, appiontmentId);
		pstmt.executeUpdate();
	}
	
	public void DeleteAppointment(int appointmentId) throws SQLException {
		String query = "DELETE FROM appointments WHERE id = ?";
		
		PreparedStatement pstmt = this.connection.prepareStatement(query);
		pstmt.setInt(1, appointmentId);
		pstmt.executeUpdate();
	}
}
