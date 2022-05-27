package com.login;

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
 * Servlet Filter implementation class LoginInputFilter
 */
@WebFilter("/LogindataServlet")
public class LoginInputFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginInputFilter() {
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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		if(username.length() > 6) {
			if(password.length() > 8) {
				// pass the request along the filter chain
				chain.doFilter(request, response);
			}else {
				httpServletResponse.sendRedirect("login.jsp?response=passwordlengthexceeds8");
			}
		}else {
			httpServletResponse.sendRedirect("login.jsp?response=usernamelengthexceeds6");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
