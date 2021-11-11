<%@include file="includes/head.jsp"%>
    <title>Home</title>
    <link rel="stylesheet" href="css/home.css">
  </head>
  <body>
    <%@include file="includes/navigation.jsp"%>
    <div class="container">
        <div id="alert_placeholder"></div>
        <form action="" method="POST">
            <div class="form-group">
                <label>Enter ID</label>
                <input type="text" id="dbid" class="form-control" placeholder="Database ID">
            </div>
            <div class="form-group">
                <label>Enter Password:</label>
                <input type="password" id="dbpassword" class="form-control" placeholder="Database Password">
            </div>
            <div class="form-group">
                <button class="btn btn-outline-success float-right" onclick="event.preventDefault(); login();">Login</button>
            </div>
        </form>
    </div>
    <%@include file="includes/bootstrapjs.jsp"%>
    <%@include file="includes/footer.jsp"%>
    <script src="js/login.js"></script>
  </body>
</html> 