<%@include file="includes/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/signup.css">
<title>Sign Up - Therapion</title>
</head>
  <body>
      <%
        String gender = (String)request.getAttribute("gender");
        int age = Integer.parseInt(request.getParameter("age"));
        String identity = (String)request.getParameter("identity");
        String country = (String)request.getParameter("country");
        String language = (String)request.getParameter("language");
        String communication_method = (String)request.getParameter("communication_method");
        String therapist_csv = (String)request.getParameter("therapist_csv");
      %>
      <div class="container">
        <form action="signup" method="post">
            <!-- hidden fields -->
            <input type="hidden" name="gender" value="<%=gender%>" />
            <input type="hidden" name="age" value="<%=age%>"/>
            <input type="hidden" name="identity" value="<%=identity%>"/>
            <input type="hidden" name="country" value="<%=country%>"/>
            <input type="hidden" name="language" value="<%=language%>"/>
            <input type="hidden" name="communicationMethod" value="<%=communication_method%>"/>
            <input type="hidden" name="therapist_csv" value="<%=therapist_csv%>"/>
            <div class="input-group mb-3">
                <span class="input-group-text" id="username_input">
                    <img src="<%=request.getContextPath()%>/img/vectors/user_vector.png"/>
                </span>
                <input type="text" class="form-control" placeholder="NAME" name="username" aria-label="Username" aria-describedby="username_input" required>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text" id="email_input">
                    <img src="<%=request.getContextPath()%>/img/vectors/user_fill_vector.png"/>
                </span>
                <input type="email" class="form-control" placeholder="EMAIL" name="email" aria-label="Email" aria-describedby="email_input" required>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text" id="password_input">
                    <img src="<%=request.getContextPath()%>/img/vectors/lock_vector.png"/>
                </span>
                <input type="password" class="form-control" placeholder="PASSWORD" name="password" aria-label="Password" aria-describedby="password_input" required>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text" id="phone_input">
                    <img src="<%=request.getContextPath()%>/img/vectors/phone_vector.png"/>
                </span>
                <input type="number" class="form-control" placeholder="PHONE" aria-label="Phone" name="phone" aria-describedby="phone_input" required>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text" id="dob_input">
                    <img src="<%=request.getContextPath()%>/img/vectors/calendar_vector.png"/>
                </span>
                <input type="date" class="form-control" placeholder="DATE OF BIRTH" aria-label="DOB" name="dob" aria-describedby="dob_input" required>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text" id="address_input">
                    <img src="<%=request.getContextPath()%>/img/vectors/house_vector.png"/>
                </span>
                <input type="text" class="form-control" placeholder="ADDRESS" aria-label="Address" name="address" aria-describedby="address_input" required>
            </div>
            <div class="input-group mb-3">
                <input type="submit" class="btn btn-light" value="SIGN UP" >
            </div>
            <div class="row">
                <a class="login_link" href="#">Already have an account?</a>
            </div>
        </form>
      </div>
<%@include file="includes/footer.jsp" %>