package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession  = req.getSession();
		httpSession.removeAttribute("is_login");
		httpSession.removeAttribute("username");
		httpSession.removeAttribute("email");
		httpSession.removeAttribute("password");
		httpSession.invalidate();
		
		resp.sendRedirect("index.jsp");
	}
}
