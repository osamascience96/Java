/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.login.validation;

import com.registeration.validation.*;
import com.service.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author osama
 */
@WebFilter("/login_controller-servlet")
public class UserExistsValidation implements Filter{
    
    private UserService registerService = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String email = request.getParameter("useremail");
        
        registerService = new UserService();
        
        if (registerService.CheckUser(email)){
            chain.doFilter(request, response);
        }else{
            HttpServletResponse httpServletResponse = (HttpServletResponse)response;
            httpServletResponse.sendRedirect("index.html?response=user-not-exists");
        }
    }

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
