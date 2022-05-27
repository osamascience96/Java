<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@page import="contants.Statements"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
<% 
	String pageTitle = "";
	Object pageTitleObj = request.getAttribute("title");
	if(pageTitleObj == null){
		pageTitle = "Home";
	}else{
		pageTitle = pageTitleObj.toString();
	}
%>
<title>Portfolio - <%=pageTitle%></title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/default.css" type="text/css" />
<link rel="icon" href="<%=request.getContextPath()%>/images/portfolio_icon.ico"/>
</head>
<body>
<div id="pseudo-wrap1"></div>
<div id="pseudo-wrap2"></div>
<!-- Begin Wrapper -->
<div id="wrap">
	<!--Begin Header -->
	<div id="header">
		<h1><a href="#" title="Green Zone">My Portfolio</a></h1>
		<p><%= Statements.header_statement %></p>
	</div>
	<!--End Header -->
<nav>
<label for="show-menu" class="responsive">&#9776; Menu</label>
<input type="checkbox" id="show-menu" role="button">
		<%
			Object currentObject = request.getAttribute("current");
		%>
		<ul id="menu">
			<li><a class="<%= currentObject == null ? "current" : ""%>" href="<%=request.getContextPath()%>">Home</a></li>
			<li><a class="<%= currentObject != null ? (currentObject.toString().compareTo("projects") == 0 ? "current" : "") : "" %>" href="<%=request.getContextPath() %>/ProjectServlet">Projects</a></li>
			<li><a class="<%= currentObject != null ? (currentObject.toString().compareTo("contactus") == 0 ? "current" : "") : "" %>" href="<%=request.getContextPath() %>/ContactUsServlet">Contact Us</a></li>
		</ul>
</nav>