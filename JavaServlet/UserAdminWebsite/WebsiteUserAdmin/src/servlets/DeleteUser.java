package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

/**
 * Servlet implementation class DeleteUser
 */
@WebServlet("/DeleteUser")
public class DeleteUser extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String serverResponse = "";
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		boolean isDeleted = new User().DeleteUser(id);
		
		serverResponse = isDeleted ? "delete_success" : "delete_failed";
		
		response.sendRedirect("Logout");
	}
}
