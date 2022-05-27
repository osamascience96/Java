package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.database.Connect;
import com.google.gson.Gson;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username_email = req.getParameter("username_email");
		String password = req.getParameter("login_password");
		
		String response = "";
		
		Connection connection = Connect.getConnectionInstance().getConnection();
		
		String query = "SELECT * FROM user WHERE (username = ? OR email = ?) AND password = ?";
		try {
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1, username_email);
			pstmt.setString(2, username_email);
			pstmt.setString(3, password);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				HttpSession httpSession = req.getSession();
				httpSession.setAttribute("is_login", true);
				httpSession.setAttribute("username", rs.getString("username"));
				httpSession.setAttribute("email", rs.getString("email"));
				httpSession.setAttribute("password", rs.getString("password"));
				response = "login_success";
			}else {
				response = "failed_success";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String jsonResponse = new Gson().toJson(response);
		resp.getWriter().println(jsonResponse);
	}
}
