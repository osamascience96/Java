package com.registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

import com.Model.User;
import com.database.ExecuteQuery;

/**
 * Servlet Filter implementation class UserExistsFilter
 */
@WebFilter("/RegisterDataServlet")
public class UserExistsFilter implements Filter {

    /**
     * Default constructor. 
     */
    public UserExistsFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		ArrayList<User> arrayUserList = null;
		ExecuteQuery sqlQuery = new ExecuteQuery();
		try {
			arrayUserList =  sqlQuery.GetUserResultSet(request.getParameter("username"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(arrayUserList.isEmpty()) {
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}else {
			HttpServletResponse servletResponse = (HttpServletResponse) response;
			servletResponse.sendRedirect("register.jsp?response=user-exists");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
