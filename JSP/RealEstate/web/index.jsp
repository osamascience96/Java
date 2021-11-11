<%@include file="includes/header.jsp" %>
    <link rel="stylesheet" href="css/home.css" >
    <title>Home</title>
  </head>
  <body>
      <%@include file="includes/navigation.jsp" %>
      <div class="container">
          <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="card">
                    <div class="card-header">Register</div>
                    <div class="card-body">
                        <form class="form-horizontal" method="post" action="register_servlet">
                            <%
                                String respond = request.getParameter("response");
                                if(respond != null){
                            %>
                                <% 
                                    String alertType = "";
                                    String titleAlert = "";
                                    String messageAlert = "";
                                    if(respond.compareTo("inserted_user") == 0){
                                        alertType = "success";
                                        titleAlert = "Record Inserted!";
                                        messageAlert = "User Inserted Successfully";
                                    }else if(respond.compareTo("already_exists") == 0){
                                        alertType = "danger";
                                        titleAlert = "Record Error!";
                                        messageAlert = "User already exists";
                                    }
                                %>
                                <div class="alert alert-<%=alertType%> alert-dismissible fade show" role="alert">
                                    <strong><%=titleAlert%></strong> <%=messageAlert%>
                                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                      <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                            <% }%>
                            <div class="form-group">
                                <label for="name" class="cols-sm-2 control-label">Your Name</label>
                                <div class="cols-sm-10">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text" id="basic-addon1"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                        </div>
                                        <input type="text" class="form-control" name="name" id="name" placeholder="Enter your Name" required>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="email" class="cols-sm-2 control-label">Your Email</label>
                                <div class="cols-sm-10">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text" id="basic-addon1"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                                        </div>
                                        <input type="email" class="form-control" name="email" id="email" placeholder="Enter your Email" required>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="username" class="cols-sm-2 control-label">Username</label>
                                <div class="cols-sm-10">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text" id="basic-addon1"><i class="fa fa-users fa" aria-hidden="true"></i></span>
                                        </div>
                                        <input type="text" class="form-control" name="username" id="username" placeholder="Enter your Username" required>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="password" class="cols-sm-2 control-label">Password</label>
                                <div class="cols-sm-10">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text" id="basic-addon1"><i class="fa fa-lock fa" aria-hidden="true"></i></span>
                                        </div>
                                        <input type="password" class="form-control" name="password" id="password" placeholder="Enter your Password" required>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label>User Type</label>
                                <div class="btn-group btn-group-toggle" data-toggle="buttons">
                                    <label class="btn btn-primary">
                                        <input type="radio" name="usertype" value="buyer" id="option2" autocomplete="off" required> Buyer
                                    </label>
                                    <label class="btn btn-success">
                                        <input type="radio" name="usertype" value="seller" id="option3" autocomplete="off" required> Seller
                                    </label>
                                </div>
                            </div>
                            <div class="form-group ">
                                <input type="submit" class="btn btn-primary btn-lg btn-block login-button" value="Register">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
      </div>
    <%@include file="modal/login.jsp" %>                      
    <%@include file="includes/bootstrapJs.jsp" %>
    <script src="js/home.js"></script>
  </body>
</html>