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

import bean.Appointment;
import model.Doctor;
import model.Patient;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/AdminAppointment")
public class AdminAppointment extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession = req.getSession();
		
		String link = "adminappointment.jsp";
		
		model.Appointment appointModel = new model.Appointment();
		model.Doctor doctorModel = new model.Doctor();
		model.Patient patientModel = new model.Patient();
		
		boolean deleteRequest = req.getParameter("delrequest") != null ? Boolean.parseBoolean(req.getParameter("delrequest")) : false;
		boolean statusRequest = req.getParameter("statusupdate") != null ? Boolean.parseBoolean(req.getParameter("statusupdate")) : false;
		
		if(deleteRequest) {
			int appointmentId = Integer.parseInt(req.getParameter("id"));
			try {
				appointModel.DeleteAppointment(appointmentId);
				link = link.concat("?response=delete_success");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(statusRequest) {
			int appointmentId = Integer.parseInt(req.getParameter("id"));
			try {
				appointModel.UpdateAppointmentStatus(appointmentId);
				link = link.concat("?response=status_success");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			httpSession.setAttribute("appointmentlists", appointModel.GetAppointmentArrayList());
			httpSession.setAttribute("doctorlists", doctorModel.GetDoctorArrayList());
			httpSession.setAttribute("patientlists", patientModel.GetPatientList());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		resp.sendRedirect(link);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int patientId = Integer.parseInt(req.getParameter("patientid"));
		int doctorId = Integer.parseInt(req.getParameter("doctorId"));
		String details = req.getParameter("detailappointment");
		String datetime = req.getParameter("date").concat(" ").concat(req.getParameter("time"));
		
		Appointment appointmentObj = new Appointment();
		appointmentObj.setPatientId(patientId);
		appointmentObj.setDoctorId(doctorId);
		appointmentObj.setDetails(details);
		appointmentObj.setAppointedDate(datetime);
		
		model.Appointment appointmentModel = new model.Appointment();
		try {
			appointmentModel.InsertAppointment(appointmentObj);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String response = new Gson().toJson("appointed_success");
		resp.getWriter().println(response);
	}
}
