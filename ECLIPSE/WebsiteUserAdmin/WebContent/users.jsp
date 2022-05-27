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
		    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		      <span class="navbar-toggler-icon"></span>
		    </button>
		    <div class="collapse navbar-collapse" id="navbarSupportedContent">
		      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
		        <li class="nav-item">
		          <a class="nav-link active" aria-current="page" href="<%=request.getContextPath()%>">Home</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link active" data-bs-toggle="modal" data-bs-target="#resetpasswordModal" aria-current="page" href="#">Reset</a>
		        </li>
		      </ul>
		      <div class="offset-md-10">
		       	<a href="Logout" class="btn btn-outline-danger" type="button">Logout</a>
		       </div>
		    </div>
		  </div>
		</nav>
		
		<div class="container mt-3">
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
	
<!-- Reset Password -->
<div class="modal fade" id="resetpasswordModal" tabindex="-1" aria-labelledby="resetpasswordModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="resetpasswordModalLabel">Reset Password</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <div class="row g-3">
       		<div class="col-lg-8 offset-md-2">
       			<div class="form-group">
       				<label class="form-label">Password</label>
       				<input id="reset_pass_input" type="password" class="form-control" placeholder="Enter Password" />
       			</div>
       		</div>
       	</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="button" class="btn btn-success" onclick="ResetPassword(<%=userObj.getId()%>)">Reset</button>
      </div>
    </div>
  </div>
</div>

<script>
	function ResetPassword(id){
		var password = $("#reset_pass_input").val();

		$.ajax("ResetPassword", {
			method: "post",
			data:{
				id: id,
				password: password,
			}
		}).done(data => {
			if(data.trim() === "password_updated"){
				window.location.replace("Logout");
			}
		})
	}
</script>
	
<%@include file="includes/footer.jsp"%>