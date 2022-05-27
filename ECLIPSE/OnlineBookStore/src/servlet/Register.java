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

import com.database.Connect;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String link = "";
		
		String username = req.getParameter("username");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		Connection connection = Connect.getConnectionInstance().getConnection();
		
		String query = "SELECT * FROM user WHERE username = ? || email = ?";
		try {
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1, username);
			pstmt.setString(2, email);
			ResultSet rs = pstmt.executeQuery();
			boolean is_exists = false;
			
			if(rs.next()) {
				is_exists = true;
			}
			
			if(is_exists) {
				link = "registration.jsp?response=user_exsts";
			}else {
				query = "INSERT INTO user(username, email, password) VALUES(?, ?, ?)";
				pstmt = connection.prepareStatement(query);
				pstmt.setString(1, username);
				pstmt.setString(2, email);
				pstmt.setString(3, password);
				pstmt.executeUpdate();
				link = "registration.jsp?response=user_inserted";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		resp.sendRedirect(link);
	}
}
