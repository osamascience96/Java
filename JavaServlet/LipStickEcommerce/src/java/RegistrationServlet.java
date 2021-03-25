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

@WebServlet(urlPatterns = {"/registration"})
public class RegistrationServlet extends HttpServlet {
    // Das Benutzermodell, das als Objekt zum Abrufen der Daten aus der Datenbank verwendet wird
    User userMode = null;

    // Die Post-Methode, mit der die Formulardaten der Registrierung vom Benutzer abgerufen werden
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String link = "";
        
        this.userMode = new User();
        
        // Daten abrufen
        String gender = req.getParameter("gender");
        String first_name = req.getParameter("first_name");
        String last_name = req.getParameter("last_name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirm_password");
        String address = req.getParameter("address");
        
        // Benutzerobjekt
        com.pojo.User user = new com.pojo.User();
        user.SetFirstName(first_name);
        user.SetLastName(last_name);
        user.SetGender(gender);
        user.SetEmail(email);
        user.SetPassword(password);
        user.SetAddress(address);
        
        try {
            // Überprüfen Sie, ob der Benutzer vorhanden ist
            if(this.userMode.CheckUserExists(user)){
                link = "login.jsp?response=user_exists";
            }else{
                // Geben Sie die Benutzerdaten ein
                this.userMode.InsertUser(user);
                link = "index.jsp?response=insert_success";
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        resp.sendRedirect(link);
    }
    
}
