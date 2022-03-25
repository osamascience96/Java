package main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Stats
 */
@WebServlet("/Stats")
public class Stats extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int value1 = Integer.parseInt(request.getParameter("value1"));
		int value2 = Integer.parseInt(request.getParameter("value2"));
		int value3 = Integer.parseInt(request.getParameter("value3"));
		int value4 = Integer.parseInt(request.getParameter("value4"));
		int value5 = Integer.parseInt(request.getParameter("value5"));
		
		int[] values = {value1, value2, value3, value4, value5};
		
		StatCalculator statCalculator = new StatCalculator(values);
		
		PrintWriter pr = response.getWriter();
		pr.write("<html>");
		pr.write("<head>");
		pr.write("<title>Locklear Statistics</title>");
		pr.write("</head>");
		pr.write("<body>");
		pr.write("<p>Statistics</p>");
		pr.write("<br>");
		pr.write("<h1 style='color:purple;'>Numbers Entered: ".concat(statCalculator.toString()).concat("</h1>"));
		Arrays.sort(values);
		pr.write("<h2 style='color:black;'>Sorted Numbers: ".concat(Arrays.toString(values)).concat("</h2>"));
		pr.write("<h3 style='color:blue;'>Sum of Numbers: ".concat(String.valueOf(statCalculator.sum())).concat("</h3>"));
		pr.write("<h4 style='color:red;'>Minimum Numbers: ".concat(String.valueOf(statCalculator.min())).concat("</h4>"));
		pr.write("<h5 style='color:green;'>Maximum Numbers: ".concat(String.valueOf(statCalculator.max())).concat("</h5>"));
		pr.write("<body>");
		pr.write("</html>");
	}

}
