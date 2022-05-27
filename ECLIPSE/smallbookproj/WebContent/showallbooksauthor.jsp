<%@page import="bean.Book"%>
<%@page import="java.util.ArrayList"%>
<%@include file="includes/head.jsp" %>
	<title>All Books</title>
  </head>
  <body>
  	<div class="container">
  		<div class="row">
  			<% ArrayList<Book> booksArrayList = (ArrayList<Book>)request.getAttribute("allbooklist"); %>
  			<% if(booksArrayList != null){ %>
  				<% for(int i=0; i < booksArrayList.size(); i++){ %>
		  			<div class="col">
		  				<div class="card" style="width: 18rem;">
						  <img class="card-img-top" src="img/bookcover.jpg" alt="Card image cap">
						  <div class="card-body">
						    <h5 class="card-title"><%=booksArrayList.get(i).getName() %></h5>
						    <p class="card-text text-primary">£<%=booksArrayList.get(i).getPrice() %></p>
						    <% String datetime[] = booksArrayList.get(i).getCreated_at().split(" "); %>
						    <div class="form-group">
						    	<input type="date" class="form-control" value="<%=datetime[0]%>">
						    </div>
						    <div class="form-group">
						    	<input type="time" class="form-control" value="<%=datetime[1]%>">
						    </div>
						  </div>
						</div>
		  			</div>
	  			<% } %>
  			<% } %>
  		</div>  		
  	</div>
    <%@include file="includes/bootstrapfiles.jsp" %>
  </body>
</html>