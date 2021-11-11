<%@page import="com.pojo.User"%>
<%
    // disable the cache to page to disable any page content in the cache
    // clearing the cache
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // Http 1.1
    response.setHeader("Pragma", "no-cache"); // Http 1.0
    if(session.getAttribute("patient_profile") == null){
        response.sendRedirect("index.jsp");
    }
%>
<%@include file="includes/header.jsp" %>
    <link rel="stylesheet" href="css/2ndTask.css" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
</head>
<body>
    <header>
        <div class="container">
            <img src="images/logo.png" alt="logo" class="logo" />
            <nav>
                <%@include file="includes/navigation_patient.jsp" %>
            </nav>
        </div>
    </header>
        <table class="side-table">
                <caption>Profile</caption>
                <%
                    User userObj = (User)session.getAttribute("patient_profile");
                %>
                <% if(userObj != null){%>
                    <tr>
                        <th>Full Name</th>
                        <td>Mr.<%=userObj.getFullname()%></td>
                    </tr>
                    <tr>
                        <th>AMKA</th>
                        <td><%=userObj.getPhone()%></td>
                    </tr>
                    <tr>
                        <th>Username</th>
                        <td><%=userObj.getUsername()%></td>
                    </tr>
                    <tr>
                        <th>Email</th>
                        <td><%=userObj.getEmail()%></td>
                    </tr>
                    <tr>
                        <th>Password</th>
                        <td class="hidetext"><%=userObj.getPassword()%></td>
                    </tr>
                <% }%>
        </table>
        <table class="hor-table" style="margin-left: 30px;">
                <caption>
                        Appointments
                </caption>
                <thead>
                    <tr>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Date</th>
                            <th>Specialty</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                            <td>Διονύσιος</td>
                            <td>Χύσσας</td>
                            <td>20/6</td>
                            <td>Ορθοπαιδικός</td>
                    </tr>
                    <tr>
                            <td>Μυρτώ</td>
                            <td>Σάββα</td>
                            <td>24/6</td>
                            <td>Δερματολόγος</td>
                    </tr>
                </tbody>
        </table>
<%@include file="includes/footer.jsp" %>
