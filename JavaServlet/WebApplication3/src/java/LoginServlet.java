

import com.conf.Constants;
import com.file.Read;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
            
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String filepath = Constants.MyLocalSystemPath.concat(Constants.MyProjectName).concat("\\src\\java\\com\\file\\FileData.txt");
            
            Read read = new Read(filepath);
            com.pojo.User user = read.CheckUserLogin(username, password);
            
            if(user != null){
                // if the login credentials are correct,
                String user_type = user.GetRole();
                // init the session to store the data
                HttpSession httpSession = request.getSession();
                // store the user object in the session 
                httpSession.setAttribute("userObj", user);
                
                if(user_type.compareTo("admin") == 0){
                    // if the user is admin 
                    link = "Admin.jsp";
                }else if(user_type.compareTo("non-admin") == 0){
                    // if the user is non-admin
                    link = "User.jsp";
                }
            }else{
                // user credentials incorrect or does not exists
                link = "login.html?response=incorrect-credentials";
            }
            
            response.sendRedirect(link);
		
//            response.setContentType("text/html");
//            PrintWriter out = response.getWriter();
//
//            User user = validateUser(request.getParameter("username"), request.getParameter("password"));
//            if (user!=null) {   // login succeeded
//            out.println("Welcome " + user.getFirstname() + " " + user.getSurname() + ".  You are now logged in!");
//            out.println("<br/><br/>Please click here to go to the <a href=\"index.html\">AccountHome page</a>");
//            HttpSession session = request.getSession();
//            session.setAttribute("theUser", user);  // put the OBJECT on the session
//            }
//            else {   // login failed
//            // no failure message for now but it will 
//            // send the user back to try again
//           System.out.println("Error message  ");
//            response.sendRedirect("login.html");   
//
//            }
//            out.close();
	 }
	    
	    /*
	     * This method will dummy the login process and return null if unsuccessful or a User object if successful
	     */
	    private User validateUser(String username,String password) {
	     // Let us first make a Vector of dummy users that are allowable... these would normally be taken from a database 
	     // or some other storage of all of our users
	     Vector<User> allUsers = new Vector<User>();
	     allUsers.add(new User("John", "Doe", "doej", "somepass"));
	     allUsers.add(new User("Mary", "Smith", "smithm", "mypass"));
	     
	     // Now do the comparison
	     Enumeration<User> e = allUsers.elements();
	     while (e.hasMoreElements()) {
	     User user = (User) e.nextElement();
	     if ((user.getPassword().equals(password))&&(user.getUsername().equals(username))) 
	     return user;
	     }
	     return null; 
	    }

	
}
