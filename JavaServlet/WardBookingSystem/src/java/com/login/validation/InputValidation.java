/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.login.validation;

import com.conf.Base64Encryption;
import java.io.IOException;
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
public class InputValidation implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String email = request.getParameter("useremail");
        String password = new Base64Encryption(request.getParameter("password")).GetEncodedString();
//        String password = request.getParameter("password");
        
        HttpServletResponse httpServletResponse = (HttpServletResponse)response;
        
        if(email.matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$")){
            if(password.length() > 8){
                chain.doFilter(request, response);
            }else{
                httpServletResponse.sendRedirect("login.html?response=password_error");
            }
        }else{
            httpServletResponse.sendRedirect("login.html?response=email-error");
        }
    }

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
