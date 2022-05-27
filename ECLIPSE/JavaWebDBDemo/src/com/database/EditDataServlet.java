package com.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.models.Record;

@WebServlet("/EditDataServlet")
public class EditDataServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int record_id = Integer.parseInt(req.getParameter("id"));
		try {
			Record recordModelData = GetOneRecord(record_id);
			req.setAttribute("record", recordModelData);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("EditData.jsp");
			requestDispatcher.forward(req, resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// function that returns the object of fetch one record from the database
	private Record GetOneRecord(int id) throws SQLException {
		Connection connect = Connect.getConnectionInstance().getConnection();
		Statement stmt = connect.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM GIRLS WHERE ID = ".concat(String.valueOf(id)));
		
		Record record = new Record();
		while(rs.next()) {
			record.setID(rs.getInt("ID"));
			record.setName(rs.getString("NAME"));
			record.setAge(rs.getInt("AGE"));
			record.setLoveStatus(rs.getInt("LOVE_STATUS"));
			record.setImageLink(rs.getString("IMG_LINK"));
			record.setCountry(rs.getString("COUNTRY"));
		}
		
		return record;
	}
}
