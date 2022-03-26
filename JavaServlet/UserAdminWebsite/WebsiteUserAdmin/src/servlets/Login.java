package servlets;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utility.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String redirUrl = "";
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if(!User.VerifyEmail(email) && !User.VerifyPassword(password)) {
			redirUrl = request.getContextPath().toString();
		}else {
			try {
				password = User.GetSHA256Password(password);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			model.User usermodel = new model.User();
			
			pojo.User userObj = usermodel.GetUserbyUserCred(email, password);
			
			if(userObj != null) {
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("user_login_obj", userObj);
				
				if(userObj.getType().compareTo("admin") == 0) {
					
					ArrayList<pojo.User> users = usermodel.GetallUsers();
					httpSession.setAttribute("users", users);
					
					redirUrl = request.getContextPath().toString() + "/dashboard.jsp";
				}else {
					redirUrl = request.getContextPath().toString() + "/users.jsp";
				}
			}else {
				redirUrl = request.getContextPath().toString() + "/?response=login_failed";
			}
		}
		
		response.sendRedirect(redirUrl);
	}

}
