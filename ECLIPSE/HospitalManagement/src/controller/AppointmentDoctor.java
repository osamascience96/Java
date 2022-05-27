package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Doctor;

/**
 * Servlet implementation class AppointmentDoctor
 */
@WebServlet("/AppointmentDoctor")
public class AppointmentDoctor extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession = req.getSession();
		
		String link = "appointmentdoctor.jsp";
		
		Doctor doctorObj = (Doctor) httpSession.getAttribute("userObj");
		
		model.Appointment appointModel = new model.Appointment();
		model.Doctor doctorModel = new model.Doctor();
		model.Patient patientModel = new model.Patient();
		
		String availableRequest = req.getParameter("availreq");
		if(availableRequest != null) {
			if(availableRequest.compareTo("on") == 0) {
				int doctorId = Integer.parseInt(req.getParameter("id"));
				try {
					doctorModel.UpdateDoctorAvailibilityOn(doctorId);
					link = link.concat("?response=availibilitysuccesson");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(availableRequest.compareTo("off") == 0) {
				int doctorId = Integer.parseInt(req.getParameter("id"));
				try {
					doctorModel.UpdateDoctorAvailibilityOff(doctorId);
					link = link.concat("?response=availibilitysuccessoff");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		try {
			httpSession.setAttribute("appointmentlists", appointModel.GetAppointmentArrayList());
			httpSession.setAttribute("doctorlists", doctorModel.GetDoctorArrayList());
			httpSession.setAttribute("patientlists", patientModel.GetPatientList());
			httpSession.setAttribute("userObj", doctorModel.GetDoctorObj(doctorObj.getUserId()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		resp.sendRedirect(link);
	}
}
