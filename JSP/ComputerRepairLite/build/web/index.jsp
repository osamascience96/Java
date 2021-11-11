<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/navigation.css">
        <link rel="stylesheet" type="text/css" href="css/index.css">
        <link rel="stylesheet" type="text/css" href="css/toast.css">
        <title>Home</title>
    </head>
    <body>
        <%@include file="includes/navigation.jsp" %>
        <h3>What is Online Computer Repair System?</h3>
        <h5>It is an online system where you can generate your request to fix your computer. You can add all the details to your system and then our experts will fix it for you. We promise our customers the best of services and we have the most entrusted professionals with us in the state of Madinah. We can operate in almost all kinds of accessories of the computer system, and will fix your problems for you in most efficient and productive way, utilizing most balanced cost for our work. We are certified from IEEM(Institute of Electronics and Engineering Madinah). We wnsure to have a great communication and healthy dealings with our clients.</h5>
        <div class="image_group">
            <img src="img/computer_repair1.jpg" width="450px" height="450px" alt="comp_repair_1"/>
            <img src="img/computer_repair2.jpg" width="450px" height="450px" alt="comp_repair_2"/>
        </div>
        <div id="snackbar"></div>
        <script type="text/javascript" src="js/toast.js"></script>
        <%
            if(request.getParameter("response") != null){
        %>
        <%
            String respond = request.getParameter("response");

            String message = "";
            if(respond.compareTo("success_login") == 0){
                message = "Logined Successfully";
            }else if(respond.compareTo("resquest_add_success") == 0){
                message = "Request Added Successfully";
            }else if(respond.compareTo("feedback_add_success") == 0){
                message = "Feedback Added Successfully";
            }
        %>
        <script>
            generate_toast('<%=message%>');
        </script>
        <%
            }
        %>
    </body>
</html>
