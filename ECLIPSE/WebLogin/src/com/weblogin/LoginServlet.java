package com.weblogin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// get the params 
		String username = req.getParameter("email_input");
		String password = req.getParameter("password_input");
		
		// init the sample user_name and password
		String user_name_test = "user9960162@gmail.com";
		String password_name_test = "firearm996brosdotcom";
	
		
		// compare the user_name_text and password_name_text
		if(user_name_test.equals(username) && password_name_test.equals(password)) {
			System.out.println("Login Successful");
		}else {
			System.out.println("Login Failed");
		}
	}
}