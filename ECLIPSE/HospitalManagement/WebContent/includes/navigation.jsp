<%@page import="bean.Doctor"%>
<%@page import="bean.User"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <%
  	String link = "index.jsp";
  	User userObj = (User) session.getAttribute("userObj");
  	if(userObj != null){
  		if(userObj.getUsertype().compareTo("admin") == 0){
  			link = "admin.jsp";
  		}else if(userObj.getUsertype().compareTo("patient") == 0){
  			link = "DoctorCotroller";
  		}else if(userObj.getUsertype().compareTo("doctor") == 0){
  			link = "AppointmentDoctor";
  		}
  	}
  %>
  <a class="navbar-brand" href="<%=link%>">
  	<img src="img/navbaricon.png" width="30" height="30" alt="homenavbaricon">
  	Home
  </a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
    <% boolean isLogin = session.getAttribute("is_login") != null ? (Boolean) session.getAttribute("is_login") : false; %>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">	
   	<% if(isLogin){%>
   		<% if(userObj.getUsertype().compareTo("admin") == 0){ %>
   			<li class="nav-item active">
        		<a class="nav-link" href="AdminDoctor">Doctors</a>
	      	</li>
	      	<li class="nav-item active">
	        	<a class="nav-link" href="AdminPatient">Patient</a>
	      	</li>
	      	<li class="nav-item active">
	        	<a class="nav-link" href="AdminAppointment">Appointments</a>
	      	</li>
   		<% }else if(userObj.getUsertype().compareTo("doctor") == 0){ %>
   			<% Doctor doctorObj = (Doctor) session.getAttribute("userObj"); %>
   			<% if(doctorObj != null){ %>
   				<% if(doctorObj.getAvailability() == 1){ %>
		   			<li class="nav-item active">
		        		<a class="btn btn-outline-danger" type="button" href="AppointmentDoctor?availreq=off&id=<%=doctorObj.getId()%>">Set Availability Off</a>
			      	</li>
		      	<%}else if(doctorObj.getAvailability() == 0){ %>
		      		<li class="nav-item active">
		        		<a class="btn btn-outline-success" type="button" href="AppointmentDoctor?availreq=on&id=<%=doctorObj.getId()%>">Set Availability On</a>
			      	</li>
		      	<%} %>
	      	<% } %>
   		<% } %>
	<% }else{ %>
      <li class="nav-item active">
        <a class="nav-link" href="DoctorCotroller">Doctors</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="register.jsp">SignUp</a>
      </li>
     <%} %>
    </ul>
    <div class="form-inline my-2 my-lg-0">
      	<% if(isLogin){ %>
      		<a href="Logout" class="btn btn-outline-danger">Logout</a>
      	<% }else{%>
      		<button class="btn btn-outline-primary my-2 my-sm-0" data-toggle="modal" data-target="#login_modal">Login</button>
      	<% }%>
    </div>
  </div>
</nav>