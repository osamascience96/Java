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

import bean.Patient;
import bean.User;
import model.Doctor;
import model.USER;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String response = "";
		
		String username_email = req.getParameter("username_email");
		String password = req.getParameter("password");
		
		USER userModel = new USER();
		
		User userObj = new User();
		userObj.setUsername(username_email);
		userObj.setEmail(username_email);
		userObj.setPassword(password);
		
		try {
			userObj = userModel.GetUserExistance(userObj);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HttpSession httpSession = req.getSession();
		
		if(userObj != null) {
			httpSession.setAttribute("is_login", true);
			response = "admin_login_success";
			if(userObj.getUsertype().compareTo("patient") == 0) {
				model.Patient patientModel = new model.Patient();
				try {
					Patient patientObj = patientModel.GetPatientObj(userObj.getId());
					httpSession.setAttribute("userObj", patientObj);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				response = "patient_login_success";
			}else if(userObj.getUsertype().compareTo("doctor") == 0) {
				Doctor doctorModel = new Doctor();
				try {
					bean.Doctor doctorObj = doctorModel.GetDoctorObj(userObj.getId());
					if(doctorObj.getApproved() == 0) {
						response = "doctor_login_success_not_approved";
					}else if(doctorObj.getApproved() == 1) {
						response = "doctor_login_success_approved";
						httpSession.setAttribute("userObj", doctorObj);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(userObj.getUsertype().compareTo("admin") == 0) {
				httpSession.setAttribute("userObj", userObj);
			}
		}else {
			response = "invalid_credentials";
		}
		
		response = new Gson().toJson(response);
		resp.getWriter().println(response);
	}
}
