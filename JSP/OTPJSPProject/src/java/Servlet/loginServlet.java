/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.Login;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "loginServlet", urlPatterns = {"/loginServlet"})
public class loginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String response = "";
        
        String proceedsignature = req.getParameter("proceedsignature");
        String userId = req.getParameter("userID");
        
        Login loginDAO = new Login();
        
        if(proceedsignature.compareTo("login_allow") == 0){
            EJB.Login loginObj = loginDAO.GetLoginExists(userId);
            
            HttpSession httpSession = req.getSession();
            
            if(loginObj != null){
                // user exists, just update the access status
                boolean isUpdated = loginDAO.UpdateLoginAvialabilityStatus(loginObj.getLoginId(), 'Y');
                response = isUpdated ?  "login_access_allowed" : "login_access_error";
                httpSession.setAttribute("login_generated_key", loginObj.getLoginId());
            }else{
                // user not exists, insert login credentials
                loginObj = new EJB.Login();
                
                loginObj.setUserId(userId);
                loginObj.setPassword("");
                loginObj.setRoleId(3);
                loginObj.setRegistrationOrUserId(userId);
                loginObj.setAccessibilityStatus("Y");
                loginObj.setCreatedBy("SELF");
                loginObj.setEnabledBy(null);
                loginObj.setEnabledDateTime(null);
                
                int generatedkey = loginDAO.InsertLoginCredentials(loginObj);
                
                response = "login_access_allowed;".concat(String.valueOf(generatedkey));
                httpSession.setAttribute("login_generated_key", generatedkey);
            }
        }else{
            response = "login_not_allowed";
        }
        
        response = new Gson().toJson(response);
        resp.getWriter().println(response);
    }
}
