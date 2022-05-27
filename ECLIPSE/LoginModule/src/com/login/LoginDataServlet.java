package com.login;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Model.User;
import com.database.ExecuteQuery;
import com.encryption.Encrypt;

@WebServlet("/LogindataServlet")
public class LoginDataServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = new Encrypt().EncryptText(request.getParameter("password"));
		ArrayList<User> arrayUserList = null;
		try {
			arrayUserList = new ExecuteQuery().GetLoginUserResultSet(username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!arrayUserList.isEmpty()) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			resp.sendRedirect("welcome.jsp");
		}else {
			resp.sendRedirect("login.jsp?response=user-not-exists");
		}
	}
}
