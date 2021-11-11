/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Constants.Path;
import FileHandling.ReadFile;
import FileHandling.WriteFile;
import Model.Intervention;
import Model.PDQ;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author osama
 */
@WebServlet(name = "FileServlet", urlPatterns = {"/file_servlet"})
public class FileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // get the latest intervention id number 
        String interventionsServerpath = req.getServletContext().getRealPath("/").concat("/data/interventions.tsv");
        ArrayList<Intervention> InterventionArrayList = new ReadFile().GetAllInterventionList(new File(interventionsServerpath));
        int newInterventionId = (InterventionArrayList.get(InterventionArrayList.size() - 1).GETIDINTERVENTION()) + 1;
        
        String pdq_num = req.getParameter("add_pdq_nb");
        String category_intervention = req.getParameter("add_cat_intervention");
        String date_incident = req.getParameter("add_date_incident");
        String quart = req.getParameter("add_quart");
        
        WriteFile writeFile = new WriteFile(Path.BASE_PATH.concat("\\web\\data\\interventions.tsv"));
        writeFile.AddIntervention(new Intervention(newInterventionId, date_incident, category_intervention, pdq_num, quart));
        
        // get the line number of the requried pdq number 
        ReadFile readFile = new ReadFile(req.getServletContext().getRealPath("/").concat("/data/pdq.csv"));
        PDQ pdq = readFile.GetPDQObject(Integer.parseInt(pdq_num));
        if(pdq != null){
            writeFile.UpdatePDQ(pdq, Path.BASE_PATH.concat("\\web\\data\\pdq.csv"));
        }
        
        resp.sendRedirect("/PoliceEuropeanProject/?add_intervention_response=success");
    }
    
}
