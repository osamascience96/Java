package com.webjava;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		int num1 = Integer.parseInt(req.getParameter("num1"));
		int num2 = Integer.parseInt(req.getParameter("num2"));
		
		int result = num1 + num2;
		
		// print the result on the response page
		PrintWriter out = res.getWriter();
		out.println("The Sum is " + result);
		
		//printing the console result as well
		System.out.println("The Sum is " + result);
		
		
//		Init the context
//		ServletContext ctx = getServletContext();
//		String str = ctx.getInitParameter("phone");
//		
//		out.println("Hi ".concat(str));
		
		ServletConfig cfg = getServletConfig();
		String str = cfg.getInitParameter("name");
		out.println("Hi ".concat(str));

		
//		Cookie cookie = new Cookie("result", String.valueOf(result));
//		res.addCookie(cookie);
//		res.sendRedirect("square");
		
//		HttpSession session = req.getSession();
//		session.setAttribute("result", result);
//		res.sendRedirect("square");
		
//		res.sendRedirect("square?result=" + result);
		
		//set the result to request attribute
//		req.setAttribute("result", result);
		
		
		
//		RequestDispatcher rd = req.getRequestDispatcher("/square");
//		rd.forward(req, res);
	}
}
