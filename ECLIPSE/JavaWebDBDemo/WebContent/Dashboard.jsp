<%@page import="com.database.ShowData"%>
<%@page import="com.models.Record"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%! private ShowData showData; %>
<%! private ArrayList<Record> arrayRecordsList; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<style>
	html, body{
		margin: 0;
		padding: 0;
		scroll-behaviour: smooth;
		background-color: pink;
		font-family: sans-serif;
	}
	h2{
		background-color: purple;
		width: 50%;
		text-align: center;
		padding: 10px;	
		margin: auto;
		position: relative;
		top: 40px;
		color: white;
		border: 2px solid white;
		border-radius: 5px;
	}
	.main{
		background-color: #dddddd;
		margin: 100px auto 100px auto;
		width: 90%;
		height: 700px;
		scroll-behaviour:smooth;
		overflow-y: auto;
		border: 3px solid purple;
		border-radius: 10px;
	}
	img{
		width: 200px;
		border-radius: 5px;
	}
	table {
		background-color: white;
		margin: auto;
		font-family: sans-serif;
		border-collapse: collapse;
		width: 100%;
		height: 100%;
		position: relative;
		top: 20px;
	}
	th, td{
		border: 1px solid #dddddd;
		text-align: left;
		padding: 10px;
		font-weight: bold;
		font-size: 17px;
	}
	tr:nth-child(1){
		background-color: #dddddd;
	}
	#add_button{
		background-color: green;
		text-decoration: none;
		color: white;
		float: right;
		position: relative;
		top: 30px;
		right: 75px;
		padding: 15px;
		font-weight: bold;
		border: 2px solid purple;
		border-radius: 5px;
	}
	#add_button:hover {
		background-color: lightgreen;
		color: purple;
		transition: 0.20s ease-in;
	}
	table tr td a{
		text-decoration: none;
		padding: 10px;
		margin: auto 5px auto 5px;
		border: 2px solid #dddddd;
		border-radius: 5px;
		background-color: purple;
		color: white;
	}
	table tr td a:hover{
		border-color: purple;
		background-color: white;
		color: pink;
		transition: 0.20s ease-in;
	}
</style>
</head>
<body>
	<% 
		// init the both the object while the service method loads
		showData= new ShowData();
		arrayRecordsList = showData.GetAllData(); 
	%>
	<h2>Welcome to my Fantasy Paradise</h2>
	<a id="add_button" href="Adddata.jsp">Add Data</a>
	<div class="main">
		<table>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Age</th>
				<th>Country</th>
				<th>Love Status</th>
				<th>IMG_LINK</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<!-- getting all the data from the database -->
			<%
				for(int i=0; i < arrayRecordsList.size(); i++){
					out.println("<tr>");
					out.println("<td>".concat(String.valueOf(arrayRecordsList.get(i).getID())).concat("</td>"));
					out.println("<td>".concat(arrayRecordsList.get(i).getName()).concat("</td>"));
					out.println("<td>".concat(String.valueOf(arrayRecordsList.get(i).getAge())).concat("</td>"));
					out.println("<td>".concat(arrayRecordsList.get(i).getCountry()).concat("</td>"));
					out.println("<td>".concat(String.valueOf(arrayRecordsList.get(i).getLoveStatus())).concat("%</td>"));
					out.println("<td style='text-align:center;'>".concat("<img alt='image' src='").concat(arrayRecordsList.get(i).getImageLink()).concat("'>").concat("</td>"));
					// edit data
					out.println("<td>".concat("<a href='").concat("EditDataServlet?id=").concat(String.valueOf(arrayRecordsList.get(i).getID())).concat("'>Edit</a></td>"));
					// delete data
					out.println("<td>".concat("<a href='").concat("DeleteDataServlet?id=").concat(String.valueOf(arrayRecordsList.get(i).getID())).concat("'>Delete</a></td>"));
					out.println("</tr>");
				}
			%>
		</table>
	</div>
</body>
</html>