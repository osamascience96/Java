/*
 * Um diesen Lizenzheader zu ändern, wählen Sie in den Projekteigenschaften Lizenzheader.
 * Um diese Vorlagendatei zu ändern, wählen Sie Extras | Vorlagen
 * und öffnen Sie die Vorlage im Editor.
 */

import com.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/login_servlet"})
public class LoginServlet extends HttpServlet {
    // Benutzermodell zum Abrufen der Daten aus der Datenbank
    User userModel = null;

    // Die Post-Methode, die die Formulardaten der Benutzeranmeldedaten akzeptiert
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String link = "";
        
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        
        this.userModel = new User();
        
        com.pojo.User user = new com.pojo.User();
        user.SetEmail(email);
        user.SetPassword(password);
        
        try {
            if(userModel.CheckLogin(user)){
                // setting the session of the user
                com.pojo.User userObj = this.userModel.GetUserData(email);
                HttpSession httpSession = req.getSession();
                httpSession.setAttribute("userObj", userObj);
                link = "index.jsp?response=login_successful";                
            }else{
                link = "index.jsp?response=login_failed";
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        resp.sendRedirect(link);
    }
    
}
