<%@page import="java.util.Base64"%>
<%@page import="bean.Doctor"%>
<%@page import="java.util.ArrayList"%>
<%@include file="includes/head.jsp" %>
<link rel="stylesheet" type="text/css" href="css/doctor.css">
<title>Doctor</title>
  </head>
  <body>
	<%@include file="includes/navigation.jsp" %>
	<div class="container">
		<div class="row justify-content-center">
			<% ArrayList<Doctor> doctorArrayList = (ArrayList<Doctor>)session.getAttribute("doctorsList"); %>
			<% if(doctorArrayList != null){ %>
				<% for(int i=0; i < doctorArrayList.size(); i++){ %>
					<div class="card">
						<% if(doctorArrayList.get(i).getImage().length() != 0){ %>
							<%
			             		byte[] imageBytes = doctorArrayList.get(i).getImage().getBytes(1, (int)doctorArrayList.get(i).getImage().length());
                                String encodedImage = Base64.getEncoder().encodeToString(imageBytes);
                                String image = "data:image/jpg;base64,".concat(encodedImage);
		             		%>
		             		<img class="card-img-top" src="<%=image%>" style="height:250px;" alt="Card image cap">
						<% }else{ %>
							<img class="card-img-top" src="img/doctororderthumb.png" alt="Card image cap">
						<% } %>
					  <div class="card-body">
					    <h5 class="card-title"><%=doctorArrayList.get(i).getName() %></h5>
					    <p class="card-text"><i class="fa fa-envelope" aria-hidden="true"></i> <%=doctorArrayList.get(i).getEmail()%></p>
					    <a href="DoctorDetails?userid=<%=doctorArrayList.get(i).getUserId() %>" class="btn btn-primary btn-block">See Details</a>
					  </div>
					</div>
				<% } %>
			<% }else{ %>
				<h4 class="text-danger text-center">No Doctors Available Right Now</h4>
			<% } %>
		</div>
	</div>
    <%@include file="includes/bootstrap.jsp" %>
    <% if(doctorArrayList != null){ %>
    	<% if(doctorArrayList.size() <= 3){ %>
    		<%@include file="includes/fixedbottomfotter.jsp" %>
    	<%}else{ %>
    		<%@include file="includes/footer.jsp" %>
    	<%} %>
    <% } %>
  </body>
</html>