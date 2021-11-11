<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Response</title>
    </head>
    <body>
        <%
            String responseMessage = request.getParameter("message").toString();
            
            if(responseMessage != null){
        %>
            <%
                if(responseMessage.compareTo("field_missing") == 0){
            %>
                <h1>You are required to fill in all the fields(Username, Password, Last Name, and First Name)</h1>
            <% }else if(responseMessage.compareTo("user_updated") == 0){%>
                <%
                    String firstname = request.getParameter("firstname");
                    String lastname = request.getParameter("lastname");
                %>
                <h3>Hi <%=firstname%> <%=lastname%> your first and last names are now updated in the database</h3>
            <% }else if(responseMessage.compareTo("user_not_updated") == 0){%>
                <%
                    String firstname = request.getParameter("firstname");
                    String lastname = request.getParameter("lastname");
                %>
                <h3>Hi <%=firstname%> <%=lastname%> your first and last names couldn't be updated in the database</h3>
            <% }else if(responseMessage.compareTo("invalid_credentials") == 0){%>
                <h1>Username and Password are not correct, please try again!</h1>
            <% }else if(responseMessage.compareTo("login_credentials_missing") == 0){%>
                <h3>To reset, kindly provide the username and password credentials!</h3>
            <% }else if(responseMessage.compareTo("data_reset_success") == 0){%>
                <h3>Your Data is reset Successfully!</h3>
            <% }else if(responseMessage.compareTo("data_reset_failed") == 0){%>
                <h3>Your Data could not be reset!</h3>
            <% }%>
        <% }else{
            // redirect to the homepage
            response.sendRedirect(request.getContextPath());
        }%>
    </body>
</html>
