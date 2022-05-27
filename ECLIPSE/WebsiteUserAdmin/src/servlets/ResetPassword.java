package servlets;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

/**
 * Servlet implementation class ResetPassword
 */
@WebServlet("/ResetPassword")
public class ResetPassword extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String serverResponse = "";
		
		int id = Integer.parseInt(request.getParameter("id"));
		String password = request.getParameter("password");
		
		if(!utility.User.VerifyPassword(password)) {
			serverResponse = "password_format_invalid";
		}else {
			boolean is_updated = false;
			try {
				is_updated = new User().UpdatePassword(id, utility.User.GetSHA256Password(password));
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(is_updated) {
				serverResponse = "password_updated";
			}else {
				serverResponse = "password_updated_failed";
			}
		}
		
		response.getWriter().println(serverResponse);
	}

}
