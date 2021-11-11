

import com.conf.Constants;
import com.file.Read;
import com.file.Write;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormServlet
 */
@WebServlet("/FormServlet")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // TODO Auto-generated method stub
            String link = "";
            
            String user_id = request.getParameter("userid");
            String first_name = request.getParameter("fname");
            String last_name = request.getParameter("lname");
            String email = request.getParameter("email");
            String phone = request.getParameter("mobile");
            String password = request.getParameter("passid");
            String filepath = Constants.MyLocalSystemPath.concat(Constants.MyProjectName).concat("\\src\\java\\com\\file\\FileData.txt");
            
            Read reader = new Read(filepath);
            if(reader.CheckUserEsistance(user_id, password) == null){
                // user not exists.
                // register to the file
                Write write = new Write(filepath);
                write.Register(new com.pojo.User(user_id, first_name, last_name, email, password, phone, "non-admin"));
                link = "login.html?response=user_register_success";
            }else{
                // user exists
                link = "register.html?response=user_exists";
            }
            
            response.sendRedirect(link);
            
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		 response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//               
//        out.println("<html><head><title>Successful Registration</title></head>");
//        out.println("<body><h1>Hello " + request.getParameter("fname") + " "  
//           + request.getParameter("lname") + "</h1>");
//        out.println("Your account " + request.getParameter("userid") + " is successfully created!");
//        out.println("An email confirmation has been sent to " + request.getParameter("email") + " and SMS confirmation to " + request.getParameter("mobile"));
//        out.println("</body></html>");
//        out.close();
//	
//		
//		doGet(request, response);
        
	}

}
