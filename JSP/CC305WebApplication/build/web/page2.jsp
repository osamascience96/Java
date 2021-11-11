<%@include file="includes/header.jsp" %>
    <title>Home</title>
    <link rel="stylesheet" type="text/css" href="css/page2.css">
    </head>
    <body>
        <%
            String submit = request.getParameter("is_submit");
            if(submit != null){
        %>
            <%
                if(submit.compareTo("true") == 0){
            %>
                <%
                    int result = 0;
                    int num1 = Integer.parseInt(request.getParameter("num1"));
                    int num2 = Integer.parseInt(request.getParameter("num2"));
                    
                    String operate = request.getParameter("operate");
                    if(operate.compareTo("plus") == 0){
                        result = num1 + num2;
                    }else if(operate.compareTo("minus") == 0){
                        result = num1 - num2;
                    }else if(operate.compareTo("multiply") == 0){
                        result = num1 * num2;
                    }
                %>
                <h2>The Result is: <%=result%></h2>
            <% }%>
        <% }else{%>
            <form id="arithmeticform" action="#" method="post">
                <h2>Arithmetic Operations</h2>
                <label>Parameter 1:</label> <input type="number" id="num1" name="num1" required> <br>
                <label>Parameter 2:</label> <input type="number" id="num2" name="num2" required> <br>
                <input type="radio" id="plus" name="operate" value="plus" required>
                <label for="plus">+</label>
                <br>
                <input type="radio" id="minus" name="operate" value="minus" required>
                <label for="minus">-</label>
                <br>
                <input type="radio" id="multiply" name="operate" value="multiply" required>
                <label for="multiply">x</label>
                <br>
                <input type="hidden" name="is_submit" value="true">
                <input type="submit" name="submit" value="Submit"> <br>
                <a href="page2b.jsp">Part B</a>
            </form>
        <% }%>
    </body>
</html>
