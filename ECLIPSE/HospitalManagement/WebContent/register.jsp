<%@include file="includes/head.jsp" %>
<link rel="stylesheet" type="text/css" href="css/register.css">
<title>Register</title>
  </head>
  <body>
	<%@include file="includes/navigation.jsp" %> 
	<div class="container">
		<%
			String resp = request.getParameter("response");
			if(resp != null){
		%>
			<%
				if(resp.compareTo("patient_inserted") == 0){
			%>
				<div class="alert alert-success alert-dismissible fade show" role="alert">
				  <strong>Successful!</strong> Signed up as a Patient.
				  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
				    <span aria-hidden="true">&times;</span>
				  </button>
				</div>
			<% }else if(resp.compareTo("doctor_inserted") == 0){ %>
				<div class="alert alert-success alert-dismissible fade show" role="alert">
				  <strong>Successful!</strong> Signed up as a Doctor.
				  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
				    <span aria-hidden="true">&times;</span>
				  </button>
				</div>
			<% }else if(resp.compareTo("userexists") == 0){ %>
				<div class="alert alert-danger alert-dismissible fade show" role="alert">
				  <strong>Failed!</strong> User Already Exists.
				  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
				    <span aria-hidden="true">&times;</span>
				  </button>
				</div>
			<% } %>
		<% } %>
		<form action="Register" method="post" enctype="multipart/form-data">
			<div class="form-group">
				<label for="name">Enter Name</label>
				<input id="name" type="text" class="form-control" name="name" placeholder="Enter Name" required>
			</div>
			<div class="form-group">
				<label for="username">Enter Username</label>
				<input id="username" type="text" class="form-control" name="username" placeholder="Enter Username" required> 
			</div>
			<div class="form-group">
				<label for="password">Enter Password</label>
				<input id="password" type="password" class="form-control" name="password" placeholder="Enter Password" required>
			</div>
			<div class="form-group">
				<label for="age">Enter Age</label>
				<input id="age" type="number" class="form-control" min="1" name="age" placeholder="Enter Age">
			</div>
			<div class="input-group mb-3">
			  <div class="input-group-prepend">
			    <span class="input-group-text">Upload Image</span>
			  </div>
			  <div class="custom-file">
			    <input type="file" name="inputimage" class="custom-file-input" id="inputimage">
			    <label class="custom-file-label" for="inputimage">Choose Image</label>
			  </div>
			</div>
			<div class="form-group">
				<label for="phone">Enter Phone</label>
				<input id="phone" type="tel" class="form-control" name="phone" placeholder="Enter Phone" required>
			</div>
			<div class="form-group">
				<label for="email">Enter Email</label>
				<input id="email" type="email" class="form-control" name="email" placeholder="Enter Email" required>
			</div>
			<div class="form-group">
				<label for="nic">Enter National Identity Card</label>
				<input id="nic" type="number" class="form-control" name="nic" placeholder="Enter NIC" required>
			</div>
			<div class="input-group mb-3">
			  <div class="input-group-prepend">
			    <div class="input-group-text">
			      <input id="doctor_signup_check" type="checkbox" name="check_doctor" aria-label="Checkbox for following text input">
			    </div>
			  </div>
			  <input type="text" value="Signup as a Doctor" class="form-control" aria-label="Text input with checkbox" readonly>
			</div>
			<!-- doctor input -->
			<div id="qual" class="form-group" style="display: none;">
				<label for="qualifications">Qualification</label>
				<textarea id="qualifications" class="form-control" rows="10" name="qualification" placeholder="Enter Your Qualifications"></textarea>
			</div>
			<div id="cure" class="form-group" style="display: none;">
				<label for="cures">Cures</label>
				<textarea id="cures" class="form-control" rows="10" name="cures" placeholder="Enter Your Cures"></textarea>
			</div>
			<input type="submit" class="btn btn-outline-dark btn-block" value="SignUp">
		</form>
	</div>
    <%@include file="includes/bootstrap.jsp" %>
    <%@include file="includes/footer.jsp" %>
    <script type="text/javascript" src="js/register.js"></script>
  </body>
</html>