package com.database;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/insert_data")
public class InsertDataServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String age = String.valueOf(req.getParameter("age"));
		String love_status = String.valueOf(req.getParameter("love_status"));
		String img_link = req.getParameter("img_link");
		String country = req.getParameter("country_name");
		
		InsertDatatoDatabase insert_data_db = new InsertDatatoDatabase();
		boolean result = false;
		try {
			result = insert_data_db.InsertData(name, age, love_status, img_link, country);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		resp.sendRedirect("Dashboard.jsp?is_inserted=".concat(String.valueOf(result)));
	}
}
