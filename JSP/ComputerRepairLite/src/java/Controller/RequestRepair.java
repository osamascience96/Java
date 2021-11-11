/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.RepairRequest;
import POJO.Request;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "RequestRepair", urlPatterns = {"/RequestRepair"})
public class RequestRepair extends HttpServlet {
    String link = "/ComputerRepairShop";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // getting the params
        String computerOwner = req.getParameter("computer_owner");
        String serialNumber = req.getParameter("serial_number");
        String type = req.getParameter("type_options");
        String model = req.getParameter("computer_model");
        String memory_gb = req.getParameter("memory_db");
        String hard_gb = req.getParameter("harddisk_gb");
        String problems = req.getParameter("problem_box");
        String current_date_time = req.getParameter("datetime");
        
        // init the request object
        Request request = new Request();
        request.SetComputerOwner(computerOwner);
        request.SetSerialNumber(serialNumber);
        request.SetType(type);
        request.SetModel(model);
        request.SetMemoryGB(Integer.parseInt(memory_gb));
        request.SetHardGB(Integer.parseInt(hard_gb));
        request.SetProblem(problems);
        request.SetRepairDelieveryDateTime(current_date_time);
        
        RepairRequest repairRequest = new RepairRequest();
        repairRequest.InsertRequestRecord(request);
        
        resp.sendRedirect("index.jsp?response=resquest_add_success");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String link = "index.jsp";
        HttpSession httpSession = req.getSession();
        ArrayList<Request> RequestArrayList = new RepairRequest().GetAllRequests();
        httpSession.setAttribute("session_request_list", RequestArrayList);
        link = "browserecords.jsp";
        
        resp.sendRedirect(link);
    }
}
