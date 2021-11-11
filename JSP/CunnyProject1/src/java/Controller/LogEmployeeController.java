/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Bean.Log;
import Bean.Student;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author osama
 */
@WebServlet(name = "LogEmployeeController", urlPatterns = {"/log_employee_controller"})
public class LogEmployeeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Model.Student studentModel = new Model.Student();
        
        HttpSession httpSession = req.getSession();
        
        try {
            ArrayList<Student> studentArrayList = studentModel.GetAllStudents();
            httpSession.setAttribute("studentlist", studentArrayList);
        } catch (SQLException ex) {
            Logger.getLogger(LogEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        resp.sendRedirect("logmodify.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int employeeId = Integer.parseInt(req.getParameter("employeeId"));
        
        Model.Student studentModel = new Model.Student();
        
        ArrayList<Log> logsArrayList = null;
        
        try {
            logsArrayList = studentModel.GetAllLogsList(employeeId);
        } catch (SQLException ex) {
            Logger.getLogger(LogEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String response = new Gson().toJson(logsArrayList);
        resp.getWriter().println(response);
    }
    
    
    
}
