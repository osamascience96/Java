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

import bean.Author;
import bean.Book;
import database.Connect;

/**
 * Servlet implementation class getallbooks
 */
@WebServlet("/getallbooks")
public class getallbooks extends HttpServlet {
	
	private Connection connection = Connect.getConnectionInstance().getConnection();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String query = "SELECT book.*, author.name as AuthorName FROM `book` JOIN author ON author.id = book.author_id";
		
		ArrayList<Book> booksArrayList = new ArrayList<Book>();
		
		try {
			PreparedStatement pstmt = this.connection.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				Author author = new Author();
				author.setId(rs.getInt("author_id"));
				author.setName(rs.getString("AuthorName"));
				
				booksArrayList.add(new Book(rs.getInt("id"), author, rs.getString("name"), rs.getDouble("price"), rs.getString("created_at")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		req.setAttribute("booksList", booksArrayList);
		
		RequestDispatcher rs = req.getRequestDispatcher("index.jsp");
		rs.forward(req, resp);
	}
}
