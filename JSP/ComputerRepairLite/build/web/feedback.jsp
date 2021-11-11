<%@page import="POJO.User"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/navigation.css">
        <link rel="stylesheet" type="text/css" href="css/index.css">
        <title>Feedback</title>
    </head>
    <body>
        <%@include file="includes/navigation.jsp" %>
        <%
            User userObj = (User)session.getAttribute("userObj");
        %>
        <div class="form-style-6">
            <h1>Add Feedback</h1>
            <form action="Feedback" method="POST">
                <input type="text" name="name" placeholder="Full Name" value="<%=userObj != null ? userObj.getFullname() : ""%>" required>
                <input type="text" name="country" placeholder="Country" required>
                <input type="number" name="phone" placeholder="Phone Number" required>
                <input type="text" name="email" placeholder="Email" value="<%=userObj != null ? userObj.getEmail(): ""%>" required>
                <input type="text" name="type_options" placeholder="Type" required>
                <input type="text" name="subject" placeholder="Subject" required>
                <textarea name="messages" rows="20" cols="20" placeholder="Enter Message" required></textarea>
                <input type="submit" value="Send Feedback">
            </form>
        </div>
    </body>
</html>
