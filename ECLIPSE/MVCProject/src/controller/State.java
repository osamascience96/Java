package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.mapper.Mapper;

import bean.StatePair;
import helper.UcwordsHelper;

/**
 * Servlet implementation class State
 */
@WebServlet("/state_controller_servlet")
public class State extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String link = "index.jsp";
		
		String usState = UcwordsHelper.UCFirst(req.getParameter("state"));
		
		StatePair statePair = new model.Mapper(usState).GetStatePairObject();
		
		HttpSession httpSession = req.getSession();
		
		if(statePair != null) {
			httpSession.setAttribute("state_session", statePair);
			link = link.concat("?response=state_found");
		}else {
			link = link.concat("?response=no_states");
		}
		
		resp.sendRedirect(link);
	}
}
