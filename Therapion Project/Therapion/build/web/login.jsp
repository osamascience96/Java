<%@include file="includes/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/signin.css">
<title>Sign In - Therapion</title>
</head>
  <body>
      <div class="container">
        <form action="LoginController" method="post">
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
                <input type="submit" class="btn btn-light" value="LOGIN" >
            </div>
            <div class="row">
                <a class="login_link" href="#">Forgot Password?</a>
                <a class="login_link" href="survey.jsp">Don't have an account?</a>
            </div>
        </form>
      </div>
<%@include file="includes/footer.jsp" %>