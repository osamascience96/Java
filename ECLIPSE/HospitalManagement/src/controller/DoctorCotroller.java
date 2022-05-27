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
 * Servlet implementation class DoctorCotroller
 */
@WebServlet("/DoctorCotroller")
public class DoctorCotroller extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Doctor doctorModel = new Doctor();
		
		HttpSession httpSession = req.getSession();
		
		try {
			httpSession.setAttribute("doctorsList", doctorModel.GetDoctorArrayList());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		resp.sendRedirect("doctor.jsp");
	}
}
