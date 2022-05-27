package com.registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.UpdateQuery;
import com.encryption.Encrypt;

@WebServlet("/RegisterDataServlet")
public class RegisterDataServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String username = req.getParameter("username");
		String password = new Encrypt().EncryptText(req.getParameter("password"));
		
		UpdateQuery updateQuery = new UpdateQuery();
		int is_registered = 0;
		try {
			is_registered = updateQuery.RegisterUserDB(name, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(is_registered > 0) {
			resp.sendRedirect("login.jsp?registration-success");
		}else {
			HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
			httpServletResponse.sendRedirect("register.jsp?response=register-fail");
		}
	}
}
