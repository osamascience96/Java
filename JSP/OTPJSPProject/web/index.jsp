<%@include file="includes/head.jsp" %>
    <title>Home</title>
    <link rel="stylesheet" href="CSS/home.css">
  </head>
  <body>
      <!-- navigation -->
      <%@include file="includes/navigation.jsp" %>
      <div class="container-fluid">
          <div class="container">
              <!-- Home Animation -->
              <img id="home_anim" src="img/home_animation.gif">
              <!-- get started button -->
              <a id="get_started_reg_link" href="register.jsp" class="btn btn-outline-primary btn-block">Get Started</a>
          </div>
      </div>
    
    <%@include file="includes/bootstrapJSP.jsp" %>
  </body>
</html>