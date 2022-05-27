package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Course;
import bean.User;
import dbutils.DBUtility;

public class DataModel {
	private Connection connection;
	
	public DataModel() {
		this.connection = DBUtility.GetConnectorInstance().GetConnection();
	}
	
	public User CheckUserExistanceSSN(String ssn) throws SQLException {
		User user = null;
		
		String query = "SELECT * FROM public.user WHERE ssn = ?";
		
		PreparedStatement pstmt = this.connection.prepareStatement(query);
		pstmt.setString(1, ssn);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			user = new User();
			
			user.setId(rs.getInt("id"));
			user.setSsn(rs.getString("ssn"));
			user.setName(rs.getString("name"));
			user.setCourses_id_string((String[])rs.getArray("course_id_array").getArray());
			user.setPassword(rs.getString("password"));
		}
		
		return user;
	}
	
	public Course GetCoursesList(int id) throws SQLException{
		Course course = null;
		
		String query = "SELECT * FROM public.courses WHERE id = ?";
		
		PreparedStatement pstmt = this.connection.prepareStatement(query);
		pstmt.setInt(1, id);
		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			course = new Course(rs.getInt("id"), rs.getString("name"), rs.getString("grades"));
		}
		
		return course;
	}
}
