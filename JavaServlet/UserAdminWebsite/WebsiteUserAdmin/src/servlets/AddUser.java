package servlets;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utility.User;

/**
 * Servlet implementation class AddUser
 */
@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String responseServer = "";
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if(!User.VerifyEmail(email) && !User.VerifyPassword(password)) {
			responseServer = "username_password_not_valid";
		}else {
			pojo.User userObj = new pojo.User();
			userObj.setName(name);
			userObj.setEmail(email);
			userObj.setType("user");
			try {
				userObj.setPassword(User.GetSHA256Password(password));
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			boolean is_inserted = new model.User().AddUser(userObj);
			
			if(is_inserted) {
				responseServer = "user_add_success";
			}else {
				responseServer = "user_add_failed";
			}
		}
		
		response.getWriter().println(responseServer);
	}

}
