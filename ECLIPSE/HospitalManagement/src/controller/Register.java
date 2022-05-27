package controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import bean.Doctor;
import bean.Patient;
import bean.User;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
@MultipartConfig(maxFileSize = -1L)
public class Register extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String link = "register.jsp";
		
		String name = req.getParameter("name");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		int age = Integer.parseInt(req.getParameter("age"));
		Part part = req.getPart("inputimage");
		InputStream is = part.getInputStream();
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		String nic = req.getParameter("nic");
		String checkbox = req.getParameter("check_doctor");
		String qualifications = req.getParameter("qualification");
		String cures = req.getParameter("cures");
		
		User userobj = new User();
		userobj.setUsername(username);
		userobj.setEmail(email);
		userobj.setPassword(password);
		
		if(checkbox != null) {
			if(checkbox.compareTo("on") == 0) {
				userobj.setUsertype("doctor");
			}
		}else {
			userobj.setUsertype("patient");
		}
		
		model.USER userModel = new model.USER();
		try {
			boolean userExistance = userModel.CheckUserExistance(userobj);
			if(!userExistance) {
				int generatedId = userModel.InsertUser(userobj);
				// check if the signup request is the doctor
				if(checkbox != null) {
					if(checkbox.compareTo("on") == 0) {
						Doctor doctorObj = new Doctor();
						doctorObj.setUserId(generatedId);
						doctorObj.setName(name);
						doctorObj.setAge(age);
						doctorObj.SetInputStream(is);
						doctorObj.setPhone(phone);
						doctorObj.setEmail(email);
						doctorObj.setQualification(qualifications);
						doctorObj.setCures(cures);
						doctorObj.setNid(nic);
						
						model.Doctor doctorModel = new model.Doctor();
						doctorModel.InsertDoctor(doctorObj);
						
						link = link.concat("?response=doctor_inserted");
					}
				}else {
					Patient patientObj = new Patient();
					patientObj.setUserId(generatedId);
					patientObj.setName(name);
					patientObj.setAge(age);
					patientObj.setIs(is);
					patientObj.setPhone(phone);
					patientObj.setEmail(email);
					patientObj.setNid(nic);
					
					model.Patient patientModel = new model.Patient();
					patientModel.InsertPatient(patientObj);
					
					link = link.concat("?response=patient_inserted"); 
				}
			}else {
				link = link.concat("?response=userexists"); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		resp.sendRedirect(link);
	}
}
