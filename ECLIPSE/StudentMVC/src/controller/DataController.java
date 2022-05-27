package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Course;
import bean.User;
import model.DataModel;

/**
 * Servlet implementation class DataController
 */
@WebServlet("/DataController")
public class DataController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String link = "";
		
		int id = Integer.parseInt(req.getParameter("student_id"));
		String ssn = req.getParameter("ssn");
		String password = req.getParameter("password");
		
		HttpSession httpSession = req.getSession();
		DataModel model = new DataModel();
		
		try {
			User userObj = model.CheckUserExistanceSSN(ssn);
			if(userObj != null) {
				// check for the student id and password
				if(id == userObj.getId() && password.compareTo(userObj.getPassword()) == 0) {
					httpSession.setAttribute("userObj", userObj);
					link = "DataController";
				}else {
					link = link.concat("DBFailed.jsp");
				}
			}else {
				link = link.concat("StudentNotFound.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		resp.sendRedirect(link);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String link = "";
		
		HttpSession httpSession = req.getSession();
		User userObj = (User) httpSession.getAttribute("userObj");
		
		DataModel dataModel = new DataModel();
		
		if(userObj != null) {
			String[] idsArray = userObj.getCourses_id_string();
			ArrayList<Course> CourseArrayList = new ArrayList<Course>();
			
			for(int i=0; i < idsArray.length; i++) {
				Course course;
				try {
					course = dataModel.GetCoursesList(Integer.parseInt(idsArray[i]));
					if(course != null) {
						CourseArrayList.add(course);
					}
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			httpSession.setAttribute("course_list", CourseArrayList);
			
			link = "courseRegistered.jsp";
		}else {
			link = "Login.jsp";
		}
		
		resp.sendRedirect(link);
	}
}
