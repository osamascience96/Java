<%@include file="includes/head.jsp" %>
<link rel="stylesheet" type="text/css" href="css/admin.css">
<title>Admin</title>
  </head>
  <body>
	<%@include file="includes/navigation.jsp" %> 
	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // Http 1.1
	    response.setHeader("Pragma", "no-cache"); // Http 1.0
		if(session.getAttribute("is_login") == null){
			response.sendRedirect("index.jsp");
		}else{
			// check if the usertype is admin 
			User adminUserObj = (User) session.getAttribute("userObj");
			if(adminUserObj.getUsertype().compareTo("admin") != 0){
				response.sendRedirect("index.jsp");
			}
		}
	%>
	<div class="container">
		<div class="row">
			<div class="col">
				<a href="AdminDoctor" class="btn btn-outline-success" type="button">
					<img src="img/doctbtnadmin.jpg" width="200" height="200" alt="doctorimage">
					<br>
					View Doctors
				</a>
			</div>
			<div class="col">
				<a href="AdminPatient" class="btn btn-outline-primary" type="button">
					<img src="img/patientbtnadmin.jpg" width="200" height="200" alt="patientbtnadmin">
					<br>
					View Patients
				</a>
			</div>
			<div class="col">
				<a href="AdminAppointment" class="btn btn-outline-info" type="button">
					<img src="img/appointbtnadmin.jpg" width="200" height="200" alt="appoint">
					<br>
					View Appointments
				</a>
			</div>
		</div>
	</div>
    <%@include file="includes/bootstrap.jsp" %>
    <%@include file="includes/fixedbottomfotter.jsp" %>
  </body>
</html>