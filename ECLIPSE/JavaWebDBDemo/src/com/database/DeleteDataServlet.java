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

@WebServlet("/DeleteDataServlet")
public class DeleteDataServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		try {
			boolean is_deleted = delete_record(id);
			resp.sendRedirect("Dashboard.jsp?is_deleted=".concat(String.valueOf(is_deleted)));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private boolean delete_record(int id) throws SQLException {
		Connection connect = Connect.getConnectionInstance().getConnection();
		Statement stmt = connect.createStatement();
		if(stmt.executeUpdate("DELETE FROM GIRLS WHERE ID = ".concat(String.valueOf(id))) == 1) {
			return true;
		}
		
		return false;
	}
}
