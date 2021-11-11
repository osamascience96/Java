/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import POJO.Log;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletContext;
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
@WebServlet(name = "Login", urlPatterns = {"/login_servlet"})
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("username", username);
        
        ServletContext servletContext = req.getServletContext();
        
        ArrayList<Log> logArrayList = (ArrayList<Log>)servletContext.getAttribute("loggerList");
        
        // if the logArrayList is null
        if(logArrayList != null){
            boolean is_log_exists = false;
            // check if the servletContext contains the log of this user 
            for(int i=0; i < logArrayList.size(); i++){
                if(logArrayList.get(i).GetUsername() != null){
                    if(username.compareTo(logArrayList.get(i).GetUsername()) == 0){
                        // add the object to the session 
                        Log log = logArrayList.get(i);
                        log.SetAccessTime(new Date(httpSession.getCreationTime()));
                        log.SetAuthenticationType("BASIC");
                        log.SetUserIpAddress(req.getRemoteAddr());
                        log.SetBrowser(req.getHeader("User-Agent"));
                        log.SetMilliseconds(new Date().getTime());
                        httpSession.setAttribute("log_data", log);
                        is_log_exists = true;
                        break;
                    }
                }
            }
            
            if(!is_log_exists){
                // add the object to the session 
                Log log = new Log();
                log.SetAccessTime(new Date(httpSession.getCreationTime()));
                log.SetAuthenticationType("BASIC");
                log.SetUsername(username);
                log.SetUserIpAddress(req.getRemoteAddr());
                log.SetBrowser(req.getHeader("User-Agent"));
                log.SetMilliseconds(new Date().getTime());
                httpSession.setAttribute("log_data", log);
                logArrayList.add(log);
            }
        }else{
            // init the list 
            logArrayList = new ArrayList<Log>();
            
            Log log = new Log(new Date(httpSession.getCreationTime()), "BASIC", username, req.getRemoteAddr(), req.getHeader("User-Agent"));
            // get the current date time in millis
            log.SetMilliseconds(new Date().getTime());
            // init the log object and add to the project
            logArrayList.add(log);
            
            servletContext.setAttribute("loggerList", logArrayList);
            
            httpSession.setAttribute("log_data", log);
        }
        
        resp.sendRedirect("target.jsp");
    }
    
}
