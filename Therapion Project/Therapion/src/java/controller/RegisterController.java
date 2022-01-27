/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import helper.Utility;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.Gender;
import pojo.Identity;
import pojo.Questionaire;
import pojo.Type;
import pojo.User;

/**
 *
 * @author osama
 */
@WebServlet(name = "RegisterController", urlPatterns = {"/signup"})
public class RegisterController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String response = "";
        
        String gender = req.getParameter("gender");
        String age = req.getParameter("age");
        String identity = req.getParameter("identity");
        String country = req.getParameter("country");
        String language = req.getParameter("language");
        String communication_method = req.getParameter("communication_method");
        String therapist_csv = req.getParameter("therapist_csv");
        
        if(!Utility.IsStringEmptyorNull(gender) && !Utility.IsStringEmptyorNull(age) && !Utility.IsStringEmptyorNull(identity) && !Utility.IsStringEmptyorNull(country) && !Utility.IsStringEmptyorNull(language) && !Utility.IsStringEmptyorNull(communication_method) && !Utility.IsStringEmptyorNull(therapist_csv)){
            // store all the values to the params
            req.setAttribute("gender", gender);
            req.setAttribute("age", age);
            req.setAttribute("identity", identity);
            req.setAttribute("country", country);
            req.setAttribute("language", language);
            req.setAttribute("communication_method", communication_method);
            req.setAttribute("therapist_csv", therapist_csv);
            
            response = "signup.jsp";
        }else{
            response = "survey.jsp?response='params_not_completed'";
        }
        
        RequestDispatcher rd = req.getRequestDispatcher(response);
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String phone = req.getParameter("phone");
        String dob = req.getParameter("dob");
        String address = req.getParameter("address");
        String gender = req.getParameter("gender");
        int age = Integer.parseInt(req.getParameter("age"));
        String identity = req.getParameter("identity");
        String country = req.getParameter("country");
        String language = req.getParameter("language");
        String communicationMethod = req.getParameter("communicationMethod");
        String therapist_csv = req.getParameter("therapist_csv");
        
        Type typeObj = new model.Type().GetTypeById(2);
        Gender genderObj = new model.Gender().GetGenderByName(gender);
        Identity identityObj = new model.Identity().GetIdentityByName(identity);
        
        User userObj = new User();
        userObj.setName(username);
        userObj.setType(typeObj);
        userObj.setGender(genderObj);
        userObj.setDateOfBirth(dob);
        userObj.setAddress(address);
        userObj.setEmail(email);
        userObj.setPassword(Utility.GetSHA256(password));
        userObj.setPhone(phone);
        
        int id = new model.User().InsertbyEmailPass(userObj);
        userObj.setId(id);
        
        Questionaire questionaireObj = new Questionaire();
        questionaireObj.setUser(userObj);
        questionaireObj.setGender(genderObj);
        questionaireObj.setIdentity(identityObj);
        questionaireObj.setAge(age);
        questionaireObj.setSource(communicationMethod);
        questionaireObj.setCountry(country);
        questionaireObj.setLanguage(language);
        
        String response = "";
        
        id = new model.Questionaire().InsertQuestionaire(questionaireObj);
        
        response = id > 0 ? "login.jsp" : "signup.jsp?response=error_insert_data";
        
        resp.sendRedirect(response);
    }
    
    
    
}
