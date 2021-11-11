/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modal.User;

/**
 *
 * @author osama
 */
@WebServlet(name = "register_servlet", urlPatterns = {"/register_servlet"})
public class register_servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String response = "";
        
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        
        User userModel = new User();
        
        bean.User userBean = userModel.GetUser(email);
        
        // check if the userBean is not null
        if(userBean != null){
            response = "user_already_exists";
        }else{
            userBean = new bean.User();
            // set the bean from the userdata
            userBean.setName(firstName.concat(" ").concat(lastName));
            userBean.setEmail(email);
            userBean.setPassword(password);
            // inser the userbean
            int userId = userModel.InsertUser(userBean);
            if(userId > 0){
                response = "user_insert_success";
            }else{
                response = "user_insert_failed";
            }
        }
        
        response = new Gson().toJson(response);
        resp.getWriter().println(response);
    }
    
}
