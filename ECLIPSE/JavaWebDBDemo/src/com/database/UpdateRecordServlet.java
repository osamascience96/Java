package com.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.models.Record;

@WebServlet("/UpdateRecordServlet")
public class UpdateRecordServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		int love_status = Integer.parseInt(req.getParameter("love_status"));
		String img_link = req.getParameter("img_link");
		String country = req.getParameter("country");
		
		Record record = new Record();
		record.setID(id);
		record.setName(name);
		record.setAge(age);
		record.setLoveStatus(love_status);
		record.setImageLink(img_link);
		record.setCountry(country);
		
		boolean is_edited = false;
		try {
			is_edited = edit_data(record);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		resp.sendRedirect("Dashboard.jsp?is_edited=".concat(String.valueOf(is_edited)));
	}
	
	private boolean edit_data(Record record) throws SQLException {
		String query = "UPDATE GIRLS SET NAME = '"+record.getName()+"', AGE = "+String.valueOf(record.getAge())+", LOVE_STATUS = "+String.valueOf(record.getLoveStatus())+", IMG_LINK = '"+record.getImageLink()+"', COUNTRY = '"+record.getCountry().concat("' WHERE ID = ").concat(String.valueOf(record.getID())).concat(";");
		Connection conn = Connect.getConnectionInstance().getConnection();
		Statement stmt = conn.createStatement();
		if(stmt.executeUpdate(query) == 1) {
			return true;
		}
		
		return false;
	}
}
