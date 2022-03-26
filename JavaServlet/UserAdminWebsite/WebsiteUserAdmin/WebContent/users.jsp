<%@page import="pojo.User"%>
<%@include file="includes/header.jsp"%>
	<%
		User userObj = (User) session.getAttribute("user_login_obj");
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
		
		<div class="mt-3">
			<div class="card">
				<div class="card-body">
					<div class="row g-3">
						<div class="col-xs-12 col-sm-12 col-md-4">
							<div class="form-group">
								<label class="form-label">Name</label>
								<input type="text" class="form-control" placeholder="Enter Name" value="<%=userObj.getName()%>" />
							</div>
						</div>
						<div class="offset-md-2 col-xs-12 col-sm-12 col-md-6">
							<div class="form-group">
								<label class="form-label">Email</label>
								<input type="email" class="form-control" placeholder="Enter Email" value="<%=userObj.getEmail()%>" />
							</div>
						</div>
						<div class="offset-md-2 col-xs-12 col-sm-12 col-md-6">
							<div class="form-group">
								<label class="form-label">Created</label>
								<input type="date" class="form-control" value="<%=userObj.getCreatedAt()%>" />
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	<% } %>
	
<%@include file="includes/footer.jsp"%>