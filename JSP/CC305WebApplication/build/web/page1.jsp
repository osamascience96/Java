<%@include file="includes/header.jsp" %>
    <title>Home</title>
    <link rel="stylesheet" type="text/css" href="css/page1.css">
    </head>
    <body>
        <%
            if(request.getParameter("is_submit") != null){
        %>
            <%
                if(request.getParameter("is_submit").compareTo("true") == 0){
            %>
                <%
                    String firstName = request.getParameter("first_name");
                    String lastName = request.getParameter("last_name");
                    String email = request.getParameter("email");
                    String gender = request.getParameter("gender");
                %>
                <h2><%=firstName%></h2>
                <h2><%=lastName%></h2>
                <h2><%=email%></h2>
                <h2><%=gender%></h2>
            <% }%>
        <% }else{%>
            <form id="htmlform" action="#" method="post">
                <h2>HTML Form</h2>
                <label>First Name:</label> <input type="text" id="first_name" name="first_name" required> <br>
                <label>Last Name:</label> <input type="text" id="last_name" name="last_name" required> <br>
                <label>Email:</label> <input type="email" id="email" name="email" required> <br>
                <input type="radio" id="male" name="gender" value="male" required>
                <label for="male">Male</label>
                <br>
                <input type="radio" id="female" name="gender" value="female" required>
                <label for="female">Female</label>
                <br>
                <input type="hidden" name="is_submit" value="true">
                <button onclick="event.preventDefault(); submit();">Submit</button>
                <button onclick="event.preventDefault(); reset();">Reset</button> <br>
                <a href="Page1b.jsp">Part B</a>
            </form>
        <% }%>
    </body>
</html>
