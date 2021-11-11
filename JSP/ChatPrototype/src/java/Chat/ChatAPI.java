/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chat;

import Pojo.Comment;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.Stack;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author osama
 */
@WebServlet(name = "ChatAPI", urlPatterns = {"/chat_api"})
public class ChatAPI extends HttpServlet {

    // Chat API is a servlet when send request to , returns the data inside the ServletContext, the data this far stored.
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=UTF-8");
        
        ServletContext servletContext = getServletContext();
        Stack<Comment> stackComment = (Stack<Comment>)servletContext.getAttribute("comment_stack");
        
        String json = new Gson().toJson(stackComment);
        resp.getWriter().write(json);
    }
    
}
