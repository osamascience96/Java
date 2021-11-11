<%@page import="java.util.Base64"%>
<%@page import="Bean.Car"%>
<%@page import="java.util.ArrayList"%>
<%@include file="includes/header.jsp" %>
        <title>Home</title>
        <link rel="stylesheet" type="text/css" href="css/home.css">
    </head>
    <body>
        <%@include file="includes/navigation.jsp" %>
        <%
            boolean isLogin = false;
            isLogin = session.getAttribute("is_login") != null ? true : false;
            
            if(!isLogin){
        %>
            <div class="container" id="container">
                <div class="form-container sign-up-container">
                    <form id="register_form" action="register_servlet" method="post">
                        <h1>Create Account</h1>
                        <input type="text" id="username" name="username" placeholder="Username" required>
                        <span id="username_register_span" style="background-color: whitesmoke; color: red;"></span>
                        <input type="email" id="email" name="email" placeholder="Email" required>
                        <span id="email_register_span" style="background-color: whitesmoke; color: red;"></span>
                        <input type="password" id="password" name="password" placeholder="Password" required>
                        <span id="password_register_span" style="background-color: whitesmoke; color: red;"></span>
                        <button onclick="event.preventDefault(); register();">Sign Up</button>
                    </form>
                </div>
                <div class="form-container sign-in-container">
                    <form action="login_servlet" method="post">
                        <h1>Sign in</h1>
                        <input type="email" placeholder="Email" id="email_login" name="email_login" required>
                        <input type="password" placeholder="Password" id="pass_login" name="pass_login" required>
                        <button>Sign In</button>
                    </form>
                </div>
                <div class="overlay-container">
                        <div class="overlay">
                                <div class="overlay-panel overlay-left">
                                        <h1>Welcome Back!</h1>
                                        <p>Login with your personal info</p>
                                        <button class="ghost" id="signIn">Sign In</button>
                                </div>
                                <div class="overlay-panel overlay-right">
                                        <h1>Hello, Friend!</h1>
                                        <p>Enter your personal details and start journey with us</p>
                                        <button class="ghost" id="signUp">Sign Up</button>
                                </div>
                        </div>
                </div>
            </div>
        <% }else{%>
            <%
                ArrayList<Car> arrayListCars = (ArrayList<Car>) session.getAttribute("carsList");
            %>
            <%
                if(arrayListCars != null){
            %>
                <%
                    if(arrayListCars.size() > 0){
                %>
                    <table id="customers">
                        <tr>
                          <th>Username</th>  
                          <th>Manufacturer</th>
                          <th>Model</th>
                          <th>Type</th>
                          <th>Price</th>
                          <th>Miles</th>
                          <th>Comments</th>
                          <th>AC</th>
                          <th>DVD</th>
                          <th>Image</th>
                          <th>Date/Time</th>
                        </tr>
                        <%
                            for(int i=0; i < arrayListCars.size(); i++){
                        %>
                            <tr>
                                <td><%=arrayListCars.get(i).getUser().getUsername()%></td>
                                <td><%=arrayListCars.get(i).getManufacturer()%></td>
                                <td><%=arrayListCars.get(i).getModel()%></td>
                                <td><%=arrayListCars.get(i).getType()%></td>
                                <td>$<%=arrayListCars.get(i).getPrice()%></td>
                                <td><%=arrayListCars.get(i).getMiles()%> Km</td>
                                <td><%=arrayListCars.get(i).getComments()%></td>
                                <td><%=arrayListCars.get(i).getHasAC() == 'T' ? "Yes" : "NO"%></td>
                                <td><%=arrayListCars.get(i).getHasDVD() == 'T' ? "Yes" : "NO"%></td>
                                <%
                                    if(arrayListCars.get(i).getImage().length() != 0){
                                %>
                                <%
                                    byte[] imageBytes = arrayListCars.get(i).getImage().getBytes(1, (int)arrayListCars.get(i).getImage().length());
                                    String encodedImage = Base64.getEncoder().encodeToString(imageBytes);
                                    String image = "data:image/jpg;base64,".concat(encodedImage);
                                %>
                                    <td><img src="<%=image%>" width="100px"></td>
                                <% }else{%>
                                    <td><img src="img/default.jpg" width="100px"></td>
                                <% }%>
                                <td><%=arrayListCars.get(i).getCreated_at()%></td>
                            </tr>
                        <% }%>
                  </table>
                <% }else{%>
                    <h2>No Cars Added yet.</h2>
                <% }%>
            <% }%>
        <% }%>
        <script src="js/home.js"></script>
        <script src="js/toast.js"></script>
        <%
            String respond = request.getParameter("response");
            String message = "";
            if(respond != null){
                if(respond.compareTo("user_register_success") == 0){
                    message = "User Registered Successfully";
                }else if(respond.compareTo("login_success") == 0){
                    message = "Login Successful";
                }else if(respond.compareTo("login_error") == 0){
                    message = "Email or Password is incorrect";
                }else if(respond.compareTo("caradded_success") == 0){
                    message = "Car Added to the System Successfully";
                }
        %>
            <div id="snackbar"></div>
            <script>
                generate_toast('<%=message%>');
            </script>
        <% }%>
        <%@include file="includes/footer.jsp" %>
    </body>
</html>
