package com.webjava;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SqServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
//		int sqaureValue = Integer.parseInt(req.getParameter("result"));
		
//		HttpSession session = req.getSession();
//		int sqaureValue = (int) session.getAttribute("result");
		
		int sqaureValue = 0;
		Cookie cookieSet[] = req.getCookies();
		
		for(Cookie c: cookieSet) {
			if(c.getName().equals("result")) {
				sqaureValue = Integer.parseInt(c.getValue());
			}
		}
		
		sqaureValue *= sqaureValue;
		
		PrintWriter out = res.getWriter();
		out.println("Square Result is : " + sqaureValue);
	}
}
