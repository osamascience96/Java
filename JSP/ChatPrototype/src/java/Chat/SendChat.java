/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chat;

import Pojo.Comment;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Stack;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author osama
 */
@WebServlet(name = "SendChat", urlPatterns = {"/send_chat"})
public class SendChat extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        String link = "index.jsp";
        
        String username = (String) httpSession.getAttribute("username");
        //check if the username is null 
        if(username != null){
            boolean is_login = (Boolean) httpSession.getAttribute("isLogin");
            ServletContext application = getServletContext();
            if(is_login){
                Stack<Comment> stackComment = (Stack<Comment>)application.getAttribute("comment_stack");
                String comment = req.getParameter("comment");
                if(stackComment != null){
                    stackComment.push(new Comment(username, comment));
                }else{
                    stackComment = new Stack<Comment>();
                    stackComment.push(new Comment(username, comment));
                    application.setAttribute("comment_stack", stackComment);
                }
            }
        }else{
            link = link.concat("?response=not_login");
        }
        
        resp.sendRedirect(link);
    }
    
}
