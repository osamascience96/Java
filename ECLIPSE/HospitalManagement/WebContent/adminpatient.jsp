<%@page import="bean.Patient"%>
<%@page import="java.util.Base64"%>
<%@page import="bean.Doctor"%>
<%@page import="java.util.ArrayList"%>
<%@include file="includes/head.jsp" %>
<link rel="stylesheet" type="text/css" href="css/admin.css">
<title>Patiet - Admin</title>
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
	<div class="container-fluid">
		<!-- system patients -->
		<table id="system_patients_table" class="table">
         	<caption>List of System Patients</caption>
           	<thead>
               <th scope="col">ID</th>
               <th scope="col">Name</th>
               <th scope="col">Age</th>
               <th scope="col">Username</th>
               <th scope="col">Email</th>
               <th scope="col">Phone</th>
               <th scope="col">Image</th>
               <th scope="col">National Id Card</th>
             </thead>
             <tbody>
             	<%
             		ArrayList<Patient> patientArrayList = (ArrayList<Patient>) session.getAttribute("systempatientadminlist");
             		if(patientArrayList != null){
             	%>
             		<% for(int i=0; i < patientArrayList.size(); i++){ %>
             			<tr>
			             	<th scope="row"><%=patientArrayList.get(i).getId() %></th>
			             	<td><%=patientArrayList.get(i).getName() %></td>
			             	<td><%=patientArrayList.get(i).getAge() %></td>
			             	<td><%=patientArrayList.get(i).getUsername() %></td>
			             	<td><button type="button" class="btn btn-outline-dark" onclick="openemail('<%=patientArrayList.get(i).getEmail()%>')">Email</button></td>
			             	<td><%=patientArrayList.get(i).getPhone() %></td>
			             	<td>
				             	<% if(patientArrayList.get(i).getImage().length() != 0){ %>
				             		<%
					             		byte[] imageBytes = patientArrayList.get(i).getImage().getBytes(1, (int)patientArrayList.get(i).getImage().length());
		                                String encodedImage = Base64.getEncoder().encodeToString(imageBytes);
		                                String image = "data:image/jpg;base64,".concat(encodedImage);
				             		%>
				             		<img src="<%=image%>" alt="doc" width="50">
				             	<% }else{ %>
				             		<img src="img/patientthumb.png" alt="doc" width="50">
				             	<% } %>
			             	</td>
			             	<td><button class="btn btn-outline-warning" onclick="opennid(<%=patientArrayList.get(i).getNid()%>)">NID</button></td>
		                </tr>
	                <% } %>
                <% } %>
             </tbody>
        </table>
        
        <!-- annonymous patients -->
        <%ArrayList<Patient> patientannonymousArrayList = (ArrayList<Patient>) session.getAttribute("annonymouspatientadminlist"); %>
        <% if(patientannonymousArrayList != null){ %>
        	<% if(patientannonymousArrayList.size() > 0){ %>
		        <table id="annonymous_patients_table" class="table">
		         	<caption>List of Annonymous Patients</caption>
		           	<thead>
		               <th scope="col">ID</th>
		               <th scope="col">Name</th>
		               <th scope="col">Age</th>
		               <th scope="col">Username</th>
		               <th scope="col">Email</th>
		               <th scope="col">Phone</th>
		               <th scope="col">Image</th>
		               <th scope="col">National Id Card</th>
		             </thead>
		             <tbody>
		             	<% for(int i=0; i < patientannonymousArrayList.size(); i++){ %>
		             			<tr>
					             	<th scope="row"><%=patientannonymousArrayList.get(i).getId() %></th>
					             	<td><%=patientannonymousArrayList.get(i).getName() %></td>
					             	<td><%=patientannonymousArrayList.get(i).getAge() %></td>
					             	<td><%=patientannonymousArrayList.get(i).getUsername() %></td>
					             	<td><button type="button" class="btn btn-outline-dark" onclick="openemail('<%=patientannonymousArrayList.get(i).getEmail()%>')">Email</button></td>
					             	<td><%=patientannonymousArrayList.get(i).getPhone() %></td>
					             	<td>
						             	<img src="img/adminthumb.jpg" alt="doc" width="50">
					             	</td>
					             	<td><button class="btn btn-outline-warning" onclick="opennid(<%=patientannonymousArrayList.get(i).getNid()%>)">NID</button></td>
				                </tr>
		                <% } %>
		             </tbody>
		        </table>
	        <% }else{ %>
	        	<h5 class="text-danger text-center">There are no annonymous Patients</h5>
	        <% } %>
        <%} %>
	</div>
    <%@include file="includes/bootstrap.jsp" %>
    <%@include file="includes/fixedbottomfotter.jsp" %>
    <%@include file="modals/email.jsp" %>
    <%@include file="modals/nid.jsp" %>
    <script src="js/adminpatient.js"></script>
  </body>
</html>