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
        <title>Repair Expert</title>
    </head>
    <%
        // disable the cache to page to disable any page content in the cache
        // clearing the cache
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // Http 1.1
        response.setHeader("Pragma", "no-cache"); // Http 1.0
        if(session.getAttribute("is_login") == null){
            response.sendRedirect("index.jsp");
        }
    %>
    <%
        User userObj = (User)session.getAttribute("userObj");
    %>
    <body>
        <%@include file="includes/navigation.jsp" %>
        <h3>Online Computer Repair Form</h3>
        <h5>We provide the most easy and reliable form to our customers to fill in the detail and then we will contact you as soon as your repair order finishes. You can click from the top of the navigation to generate your request.</h5>
        <div class="image_group">
            <img src="img/repair_request1.jpg" width="450px" height="450px" alt="repair_request1"/>
            <img src="img/repair_request2.jpg" width="450px" height="450px" alt="repair_request2"/>
        </div>
        <div class="form-style-6">
            <h1>Add Repair Request</h1>
            <form action="RequestRepair" method="POST">
                <input type="text" name="computer_owner" placeholder="Computer Owner" value="<%=userObj != null ? userObj.getFullname(): ""%>" required>
                <input type="text" name="serial_number" placeholder="Serial Number" required>
                <input type="text" name="type_options" placeholder="Type" required>
                <input type="text" name="computer_model" placeholder="Model" required>
                <input type="number" name="memory_db" placeholder="Memory in GB" required>
                <input type="number" name="harddisk_gb" placeholder="Hardisk GB" required>
                <textarea name="problem_box" rows="20" cols="20" placeholder="Type your Problem" required></textarea>
                <%
                      // init the current date and time 
                      DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
                      Date dateObj = new Date();
                      String[] datetime = dateFormat.format(dateObj).split(" ");
                %>
                <input type="hidden" name="datetime" value="<%=dateFormat.format(dateObj).toString()%>">
                <input type="date" name="current_date" value="<%=datetime[0]%>" required>
                <input type="time" name="current_time" value="<%=datetime[1]%>" required>
                <input type="submit" value="Submit" >
            </form>
        </div>
    </body>
</html>
