package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.database.Connect;

import Bean.Catalog;

/**
 * Servlet implementation class Book
 */
@WebServlet("/Book")
public class Book extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String link = "";
		
		ArrayList<Catalog> catalogArrayList = new ArrayList<Catalog>();
		HttpSession httpSession = req.getSession();
		
		if(httpSession.getAttribute("is_login") != null) {
			Connection connection = Connect.getConnectionInstance().getConnection();
			
			String query = "SELECT * FROM catalog";
			try {
				PreparedStatement pstmt = connection.prepareStatement(query);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					catalogArrayList.add(new Catalog(rs.getInt("id"), rs.getString("name"), rs.getString("description"), rs.getDouble("price"), rs.getString("created_at")));
				}
				
				httpSession.setAttribute("catalog_arraylist", catalogArrayList);
				link = "catalog.jsp";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			link = "catalog.jsp";
		}
		
		resp.sendRedirect(link);
	}
}
