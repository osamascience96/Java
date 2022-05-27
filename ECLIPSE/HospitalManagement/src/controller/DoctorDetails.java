package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Doctor;

/**
 * Servlet implementation class DoctorDetails
 */
@WebServlet("/DoctorDetails")
public class DoctorDetails extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int userId = Integer.parseInt(req.getParameter("userid"));
		
		Doctor doctmodel = new Doctor();
		
		HttpSession httpSession = req.getSession();
		try {
			httpSession.setAttribute("doctordetails", doctmodel.GetDoctorObj(userId));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		resp.sendRedirect("doctordetails.jsp");
	}
}
