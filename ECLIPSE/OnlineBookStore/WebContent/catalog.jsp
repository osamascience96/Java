<!doctype html>
<%@page import="Bean.Catalog"%>
<%@page import="java.util.ArrayList"%>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Catatlog</title>
    <style>
    	.row{
    		margin-top: 20px;
    	}
    </style>
  </head>
  <body>
	<%@include file="includes/navigation.jsp" %>
	<div class="container">
		<% ArrayList<Catalog> catalogArrayList = (ArrayList<Catalog>) session.getAttribute("catalog_arraylist"); %>
		<% if(catalogArrayList != null){%>
			<div class="row">
				<% for(int i=0; i < catalogArrayList.size(); i++){ %>
					<div class="col">
						<div class="card" style="width: 18rem;">
						  <img class="card-img-top" src="img/book_card.jpg" height="200" alt="Card image cap">
						  <div class="card-body">
						  	<h5 class="card-title"><%=catalogArrayList.get(i).getName() %></h5>
						    <p class="card-text"><%=catalogArrayList.get(i).getDescription()%></p>
						    <p class="card-text text-primary">Rs.<%=catalogArrayList.get(i).getPrice()%></p>
						  </div>
						</div>
					</div>
				<% } %>
			</div>
		<% }else{ %>
			<h5>Please Login before Viewing any Catalog</h5>
		<% } %>
	</div>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <%@include file="modal/login.jsp" %>
    <%@include file="modal/logout.jsp" %>
    <script src="js/home.js"></script>
  </body>
</html>