package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import model.Doctor;

/**
 * Servlet implementation class AdminDoctor
 */
@WebServlet("/AdminDoctor")
public class AdminDoctor extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Doctor doctor = new Doctor();
		
		HttpSession httpSession = req.getSession();
		
		try {
			httpSession.setAttribute("doctoradminlist", doctor.GetDoctorArrayList());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		resp.sendRedirect("admindoctor.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String response = "";
		
		String actionType = req.getParameter("actiontype");
		int doctorId = Integer.parseInt(req.getParameter("docid"));
		
		Doctor doctorModel = new Doctor();
		
		try {
			if(actionType.compareTo("active") == 0) {
				doctorModel.UpdateDoctortoActive(doctorId);
				response = "doctor_activated";
			}else if(actionType.compareTo("deactive") == 0){
				doctorModel.UpdateDoctortoDeactive(doctorId);
				response = "doctor_deactivated";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response = new Gson().toJson(response);
		resp.getWriter().println(response);
	}
}
