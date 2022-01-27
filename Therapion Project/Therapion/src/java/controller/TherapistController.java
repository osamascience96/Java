/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.Therapist;

/**
 *
 * @author osama
 */
@WebServlet(name = "TherapistController", urlPatterns = {"/TherapistController"})
public class TherapistController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Get all the therapists
        ArrayList<Therapist> therapistList = new model.Therapist().GetAllTherapist();
        // save the obj to the request
        req.setAttribute("therapistList", therapistList);
        
        RequestDispatcher rd = req.getRequestDispatcher("therapist.jsp");
        rd.forward(req, resp);
    }
    
}
