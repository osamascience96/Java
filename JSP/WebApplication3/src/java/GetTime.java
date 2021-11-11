

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.DateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetTime
 */
@WebServlet("/GetTime")
public class GetTime extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetTime() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setContentType("text/html");
		    PrintWriter out = response.getWriter();
		    DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT, 
		      DateFormat.SHORT);   

		    Date currentDate = new Date();
		      
		    // Check for null if initial parameter isn't set - will default short
		    if (request.getParameter("format")!= null) {    

		    // if we set it to long, otherwise it will remain as short
		    if (request.getParameter("format").equals("long"))  
		       df = DateFormat.getDateTimeInstance(DateFormat.LONG, 
		       DateFormat.LONG);
		    }

		    out.println(df.format(currentDate));
		    out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
