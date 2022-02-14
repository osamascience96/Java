/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import helper.FileHandling;
import helper.JsonOps;
import helper.Operations;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONObject;

/**
 *
 * @author osama
 */
@WebServlet(name = "Login", urlPatterns = {"/loginservlet"})
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String response = "";
        
        String username = req.getParameter("j_username");
        String password = req.getParameter("j_password");
        
        String path = getServletContext().getRealPath("/").replace('\\', '/').replace("/build/web", "/src/java/");
        
        if(!Operations.IsNullOrEmpty(username) && !Operations.IsNullOrEmpty(password)){
            // Get the json object for users
            Object receivedObj = FileHandling.GetUserJson(path);
            JSONObject userJsonObject = JsonOps.GetLoginCredentials(receivedObj, username, password);
            
            if(userJsonObject != null){
                if(userJsonObject.containsKey("response")){
                    String jsonResponse = userJsonObject.get("response").toString();
                    if(jsonResponse.compareTo("login_success") == 0){
                        HttpSession httpSession = req.getSession();
                        httpSession.setAttribute("user_obj", userJsonObject);
                        response = "response.jsp?response=login_success";
                    }else{
                        response = "response.jsp?response=login_failed";
                    }
                }
            }else{
                response = "response.jsp?response=user_not_exists";
            }
        }else{
            response = "?response=cred_not_provided";
        }
        
        resp.sendRedirect(response);
    }
    
}
