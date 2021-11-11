<%@page import="bean.Member"%>
<%@page import="bean.Personnel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/main.css">
        <title>Member Panel</title>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/header.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/bootstrap.css">
        <script src="<%=request.getContextPath()%>/assets/js/jquery.js"></script>
        <script src="<%=request.getContextPath()%>/assets/js/bootstrap.js"></script>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light header justify-content-between">
            <nav class="navbar navbar-light bg-light">
                <%
                    String homepage = "";
                    
                    if(session.getAttribute("admin") != null){
                        homepage = "admin_servlet";
                    }else if(session.getAttribute("member") != null){
                        homepage = "member_servlet";
                    }else {
                        homepage = "index.jsp";
                    }
                %>
                <a class="navbar-brand" href="<%=homepage%>">
                    <img src="<%=request.getContextPath()%>/assets/images/logo.png" height="40" alt="">
                </a>
            </nav>
            <div class="navbar-collapse">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="<%=homepage%>">Home</a>
                    </li>
                    <% if (session.getAttribute("admin") != null) { %>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Actions</a>
                            <div class="dropdown-menu">
                                <a class="dropdown-item" href="books_admin_servlet">Manage Books</a>
                                <a class="dropdown-item" href="borrow_servlet">Manage Loans</a>
                                <a class="dropdown-item" href="member_admin_servlet">Manage Members</a>
                            </div>
                        </li>
                    <% }%>
                    <li class="navbar-text">
                        <%
                            String loginUsername = "";
                            if(session.getAttribute("admin") != null){
                                Personnel personnel = (Personnel) session.getAttribute("admin");
                                loginUsername = personnel.getPersonnel_login();
                            }else if(session.getAttribute("member") != null){
                                Member member = (Member) session.getAttribute("member");
                                loginUsername = member.getUsername();
                            }
                        %>
                        Welcome, <%=loginUsername%>
                    </li>
                </ul>
            </div>
            <a type="button" class="btn btn-dark" href="logout_servlet_library">Log out</a>
            </nav>
