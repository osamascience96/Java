<%@page import="bean.Patient"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.util.Base64"%>
<%@page import="bean.Doctor"%>
<%@page import="java.util.ArrayList"%>
<%@include file="includes/head.jsp" %>
<link rel="stylesheet" type="text/css" href="css/doctor.css">
<title>Doctor Details</title>
  </head>
  <body>
	<%@include file="includes/navigation.jsp" %>
	<% Patient patientObj = (Patient) session.getAttribute("userObj"); %>
	<div id="doctor_details_container" class="container">
		<div id="doctor_details_alert_placeholder"></div>
		<% Doctor doctorDetail = (Doctor)session.getAttribute("doctordetails"); %>
		<% if(doctorDetail != null){ %>
			<input type="hidden" id="inputgroupdoctors" value="<%=doctorDetail.getId() %>">
			<% if(patientObj != null){ %>
				<input type="hidden" id="inputgrouppatients" value="<%=patientObj.getId() %>">
			<%} %>
			<div class="row">
				<h1 class="col display-2"><%=doctorDetail.getName() %></h1>
				<% if(doctorDetail.getImage().length() != 0){ %>
					<%
	             		byte[] imageBytes = doctorDetail.getImage().getBytes(1, (int)doctorDetail.getImage().length());
                        String encodedImage = Base64.getEncoder().encodeToString(imageBytes);
                        String image = "data:image/jpg;base64,".concat(encodedImage);
             		%>
             		<img class="col" src="<%=image%>" style="width: 18rem;" alt="img">
				<% }else{ %>
					<img class="col" src="img/doctororderthumb.png" style="width: 18rem;" alt="img">
				<% } %>
			</div>
			<div class="row">
				<div class="col">
					<h3><i class="fa fa-envelope" aria-hidden="true"> <%=doctorDetail.getEmail() %></i></h3>
					<h3><i class="fa fa-phone" aria-hidden="true"> <%=doctorDetail.getPhone()%></i></h3>
				</div>
			</div>
			<hr>
			<h5>Qualification Details</h5>
			<div class="row">
				<div class="col">
					<% if(doctorDetail.getQualification().isEmpty()){ %>
						<h5 class="text-danger text-center">Qualification Details Not Provided</h5>
					<% }else{ %>
						<%=doctorDetail.getQualification() %>
					<% } %>
				</div>
			</div>
			<hr>
			<h5>Cures Details</h5>
			<div class="row">
				<div class="col">
					<% if(doctorDetail.getCures().isEmpty()){ %>
						<h5 class="text-danger text-center">Cures Not Provided</h5>
					<% }else{ %>
						<%=doctorDetail.getCures()%>
					<% } %>
				</div>
			</div>
			<hr>
			<div class="form-group">
				<label for="details">Enter Details</label>
				<textarea id="detailsappointment" class="form-control" rows="10" name="qualification" placeholder="Write your problem in details"></textarea>
			</div>
			<hr>
			<%
				DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				LocalDateTime localDateTime = LocalDateTime.now();
				String datetime[] = dateTimeFormatter.format(localDateTime).split(" ");
			%>
			<div class="row">
				<div class="col">
					<input type="date" id="dateappointment" class="form-control" value="<%=datetime[0]%>">
				</div>
				<div class="col">
					<input type="time" id="timeappointment" class="form-control" value="<%=datetime[1]%>">
				</div>
			</div>
			<hr>
			<% if(doctorDetail.getApproved() == 0){ %>
				<h5 class="text-info text-center">Doctor not approved for appointment</h5>
			<% }else if(doctorDetail.getAvailability() == 0){ %>
				<h5 class="text-primary text-center">Doctor Over booked for appointments right now.</h5>
			<% }else{ %>
				<% if(session.getAttribute("is_login") != null){ %>
					<button type="button" class="btn btn-outline-dark btn-block" onclick="setappointment()">Make an Appointment</button>
				<% }else{ %>
					<button type="button" class="btn btn-outline-dark btn-block" data-toggle="modal" data-target="#login_modal">Make an Appointment</button>
				<% } %>
			<% }%>
		<% }else{ %>
			<% response.sendRedirect("index.jsp"); %>
		<% }%>
	</div>
    <%@include file="includes/bootstrap.jsp" %>
    <%@include file="includes/footer.jsp" %>
    <%@include file="modals/message.jsp" %>
    <script src="js/doctordetails.js"></script>
  </body>
</html>