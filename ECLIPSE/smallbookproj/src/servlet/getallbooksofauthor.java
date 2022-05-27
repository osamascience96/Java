package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Book;
import database.Connect;

/**
 * Servlet implementation class getallbooksofauthor
 */
@WebServlet("/getallbooksofauthor")
public class getallbooksofauthor extends HttpServlet {
	
	private Connection connection = Connect.getConnectionInstance().getConnection();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int authorId = Integer.parseInt(req.getParameter("authorid"));
		
		String query = "SELECT * FROM book WHERE author_id = ?";
		ArrayList<Book> bookArrayList = new ArrayList<Book>();
		
		try {
			PreparedStatement pstmt = this.connection.prepareStatement(query);
			pstmt.setInt(1, authorId);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Book bookObj = new Book();
				bookObj.setId(rs.getInt("id"));
				bookObj.setName(rs.getString("name"));
				bookObj.setPrice(rs.getDouble("price"));
				bookObj.setCreated_at(rs.getString("created_at"));
				
				bookArrayList.add(bookObj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		req.setAttribute("allbooklist", bookArrayList);
		
		RequestDispatcher rs = req.getRequestDispatcher("showallbooksauthor.jsp");
		rs.forward(req, resp);
	}
}
