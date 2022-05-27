<%@page import="bean.Book"%>
<%@page import="java.util.ArrayList"%>
<%@include file="includes/head.jsp" %>
	<title>Home</title>
  </head>
  <body>
  	<div class="container">
  		<% ArrayList<Book> booksArrayList = (ArrayList<Book>) request.getAttribute("booksList"); %>
  		<% if(booksArrayList != null){ %>
	  		<table class="table table-hover">
			  <thead>
			    <tr>
			      <th scope="col">Title.</th>
			      <th scope="col">Author</th>
			      <th scope="col">Price</th>
			    </tr>
			  </thead>
			  <tbody>
			  	<% for(int i=0; i < booksArrayList.size(); i++){ %>
				    <tr>
				      <th scope="row"><%=booksArrayList.get(i).getName() %></th>
				      <td><a href="getallbooksofauthor?authorid=<%=booksArrayList.get(i).getAuthor().getId()%>"><%=booksArrayList.get(i).getAuthor().getName() %></a></td>
				      <td>£<%=booksArrayList.get(i).getPrice() %></td>
				    </tr>
			    <% } %>
			  </tbody>
			</table>
		<% } %>
  	</div>
    <%@include file="includes/bootstrapfiles.jsp" %>
  </body>
</html>