<%@page import="bean.Appointment"%>
<%@page import="java.util.Base64"%>
<%@page import="bean.Doctor"%>
<%@page import="java.util.ArrayList"%>
<%@include file="includes/head.jsp" %>
<link rel="stylesheet" type="text/css" href="css/admin.css">
<title>Appointments - Admin</title>
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
			if(adminUserObj.getUsertype().compareTo("doctor") != 0){
				response.sendRedirect("index.jsp");
			}
		}
	%>
	<div class="container">
		<% ArrayList<Appointment> arrayListAppointments = (ArrayList<Appointment>)session.getAttribute("appointmentlists"); %>
		<% if(arrayListAppointments != null){ %>
			<% if(arrayListAppointments.size() > 0){ %>
				<table id="appointment_table" class="table">
		         	<caption>List of Appointments</caption>
		           	<thead>
		               <th scope="col">ID</th>
		               <th scope="col">PId</th>
		               <th scope="col">PName</th>
		               <th scope="col">DId</th>
		               <th scope="col">DName</th>
		               <th scope="col">Detais</th>
		               <th scope="col">Appointed Date</th>
		               <th scope="col">Appointed Time</th>
		               <th scope="col">Status</th>
		             </thead>
		             <tbody>
		             	<% for(int i=0; i < arrayListAppointments.size(); i++){ %>
		             		<tr>
		             			<th scope="row"><%=arrayListAppointments.get(i).getId() %></th>
		             			<td><%=arrayListAppointments.get(i).getPatientId() %></td>
		             			<td><%=arrayListAppointments.get(i).getPatientObj().getName() %></td>
		             			<td><%=arrayListAppointments.get(i).getDoctorId()%></td>
		             			<td><%=arrayListAppointments.get(i).getDoctorObj().getName() %></td>
		             			<td><%=arrayListAppointments.get(i).getDetails() %></td>
		             			<%
		             				String datetime[] = arrayListAppointments.get(i).getAppointedDate().split(" ");
		             			%>
		             			<td><input type="date" value="<%=datetime[0] %>"></td>
		             			<td><input type="time" value="<%=datetime[1] %>"></td>
		             			<td><%=arrayListAppointments.get(i).getStatus().compareTo("not_received") == 0 ? "Not Receieved" : "Receieved" %></td>
		             		</tr>
		             	<% } %>
		             </tbody>
		        </table>
	        <%}else{ %>
	        	<h5 class="text-danger text-center" style="padding: 10px;">No Appointments made uptil now.</h5>
	        <%} %>
        <% }%>
	</div>
    <%@include file="includes/bootstrap.jsp" %>
    <%@include file="includes/fixedbottomfotter.jsp" %>
    <%@include file="modals/addappointment.jsp" %>
    <script src="js/adminappoint.js"></script>
  </body>
</html>