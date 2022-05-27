<%@page import="java.util.Base64"%>
<%@page import="bean.Doctor"%>
<%@page import="java.util.ArrayList"%>
<%@include file="includes/head.jsp" %>
<link rel="stylesheet" type="text/css" href="css/admin.css">
<title>Doctors - Admin</title>
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
		<table id="doctors_table" class="table">
         	<caption>List of Doctors</caption>
           	<thead>
               <th scope="col">ID</th>
               <th scope="col">Name</th>
               <th scope="col">Age</th>
               <th scope="col">Username</th>
               <th scope="col">Email</th>
               <th scope="col">Phone</th>
               <th scope="col">Image</th>
               <th scope="col">Approved</th>
               <th scope="col">Qualifications</th>
               <th scope="col">Cures</th>
               <th scope="col">National Id Card</th>
               <th scope="col">Available</th>
               <th scope="col">Actions</th>
             </thead>
             <tbody>
             	<%
             		ArrayList<Doctor> doctorArrayList = (ArrayList<Doctor>)session.getAttribute("doctoradminlist");
             		if(doctorArrayList != null){
             	%>
             		<% for(int i=0; i < doctorArrayList.size(); i++){ %>
             			<tr>
			             	<th scope="row"><%=doctorArrayList.get(i).getId() %></th>
			             	<td><%=doctorArrayList.get(i).getName() %></td>
			             	<td><%=doctorArrayList.get(i).getAge() %></td>
			             	<td><%=doctorArrayList.get(i).getUsername() %></td>
			             	<td><button type="button" class="btn btn-outline-dark" onclick="openemail('<%=doctorArrayList.get(i).getEmail()%>')">Email</button></td>
			             	<td><%=doctorArrayList.get(i).getPhone() %></td>
			             	<td>
				             	<% if(doctorArrayList.get(i).getImage().length() != 0){ %>
				             		<%
					             		byte[] imageBytes = doctorArrayList.get(i).getImage().getBytes(1, (int)doctorArrayList.get(i).getImage().length());
		                                String encodedImage = Base64.getEncoder().encodeToString(imageBytes);
		                                String image = "data:image/jpg;base64,".concat(encodedImage);
				             		%>
				             		<img src="<%=image%>" alt="doc" width="50">
				             	<% }else{ %>
				             		<img src="img/doctorthumb.png" alt="doc" width="50">
				             	<% } %>
			             	</td>
			             	<td><%=doctorArrayList.get(i).getApproved() %></td>
			             	<td><button class="btn btn-outline-primary" onclick="openqualification('<%=doctorArrayList.get(i).getQualification()%>')">Qualifications</button></td>
			             	<td><button class="btn btn-outline-info" onclick="opencures('<%=doctorArrayList.get(i).getCures()%>');">Cures</button></td>
			             	<td><button class="btn btn-outline-warning" onclick="opennid(<%=doctorArrayList.get(i).getNid()%>)">NID</button></td>
			             	<td>No</td>
			             	<td class="text-center align-middle">
			                   <div class="btn-group align-top">
			                       <button class="btn btn-sm btn-outline-primary badge" type="button" onclick="approve(<%=doctorArrayList.get(i).getId()%>)">Approve</button>
			                       <button class="btn btn-sm btn-outline-danger badge" type="button" onclick="disapprove(<%=doctorArrayList.get(i).getId()%>)"><i class="fa fa-times"></i></button>
			                   </div>	
			                </td>
		                </tr>
	                <% } %>
                <% } %>
             </tbody>
        </table>
	</div>
    <%@include file="includes/bootstrap.jsp" %>
    <%@include file="includes/fixedbottomfotter.jsp" %>
    <%@include file="modals/qualification.jsp" %>
    <%@include file="modals/cures.jsp" %>
    <%@include file="modals/nid.jsp" %>
    <%@include file="modals/email.jsp" %>
    <%@include file="modals/message.jsp" %>
    <script src="js/admindoctor.js"></script>
  </body>
</html>