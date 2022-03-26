<%@page import="java.util.ArrayList"%>
<%@page import="pojo.User"%>
<%@include file="includes/header.jsp"%>
	<%
		User userObj = (User) session.getAttribute("user_login_obj");
		ArrayList<User> users = (ArrayList<User>) session.getAttribute("users");
	%>
	<% if(userObj != null){ %>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
		  <div class="container-fluid">
		    <a class="navbar-brand" href="#"><%= userObj.getName() %></a>
		    <div class="collapse navbar-collapse" id="navbarSupportedContent">
		      <div class="row g-3">
		      	<div class="offset-md-10">
		        	<a href="Logout" class="btn btn-outline-danger" type="button">Logout</a>
		        </div>
		      </div>
		    </div>
		  </div>
		</nav>
		
		<div class="container">
			<h5 class="text-center text-primary">Welcome! <%= userObj.getName() %></h5>
		</div>
		
		<div class="mt-2">
			<div class="row g-3">
				<div class="col-lg-12">
					<table class="table">
					  <thead>
					    <tr>
					      <th scope="col">#</th>
					      <th scope="col">Name</th>
					      <th scope="col">Email</th>
					      <th scope="col">User type</th>
					    </tr>
					  </thead>
					  <tbody>
					  	<% for(User user: users){ %>
						    <tr>
						      <th scope="row"><%=user.getId() %></th>
						      <td><%=user.getName() %></td>
						      <td><%=user.getEmail() %></td>
						      <td><%=user.getType() %></td>
						    </tr>
					    <% } %>
					  </tbody>
					</table>
				</div>
			</div>
		</div>
	<% } %>
	
<%@include file="includes/footer.jsp"%>