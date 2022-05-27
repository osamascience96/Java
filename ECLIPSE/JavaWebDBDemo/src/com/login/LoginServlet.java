package com.login;

import java.io.IOException;
import java.util.Base64;
import java.util.Base64.Encoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	// init the username and password(encrypt password using BASE64)
	private String username = "osamahu01";
	private String password = "adminadmin001";
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String input_username = req.getParameter("username");
		String input_pass = req.getParameter("password");
		
		// check if the login and password are equal
		if(username.equals(input_username) && GetBase64PassString(password).equals(GetBase64PassString(input_pass))) {
			resp.sendRedirect("Dashboard.jsp");
		}else {
			resp.sendRedirect("/JavaWebDBDemo");
		}
	}
	
	private String GetBase64PassString(String pass) {
		Encoder encoder = Base64.getEncoder();
		return encoder.encodeToString(pass.getBytes());
	}
}
