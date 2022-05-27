package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Patient;

/**
 * Servlet implementation class AdminPatient
 */
@WebServlet("/AdminPatient")
public class AdminPatient extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Patient patientModel = new Patient();
		
		HttpSession httpSession = req.getSession();
		
		try {
			httpSession.setAttribute("systempatientadminlist", patientModel.GetPatientSystemList());
			httpSession.setAttribute("annonymouspatientadminlist", patientModel.GetPatientAnnonymousList());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		resp.sendRedirect("adminpatient.jsp");
	}
}
