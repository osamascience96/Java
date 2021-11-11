<%@include file="includes/head.jsp" %>
    <title>Register</title>
    <link rel="stylesheet" href="CSS/register.css">
  </head>
  <body>
      <!-- navigation -->
      <%@include file="includes/navigation.jsp" %>
      <div class="container-fluid">
          <div class="container">
              <div class="form_register">
                  <h1 class="display-4">Holding Details</h1>
                  <!-- Holding Number -->
                  <div class="input-group mb-3">
                      <div class="input-group-prepend">
                          <span class="input-group-text">Holding No.</span>
                      </div>
                      <input id="holding_no" type="text" class="form-control" placeholder="Enter your Holding Number" >
                  </div>
                  <!-- Zone Selection -->
                  <div class="input-group mb-3">
                      <div class="input-group-prepend">
                          <span class="input-group-text">Zone</span>
                      </div>
                      <select id="zone" class="custom-select">
                          <option>Zone1</option>
                          <option>Zone2</option>
                          <option>Zone3</option>
                          <option>Zone4</option>
                      </select>
                  </div>
                  <!-- owner name-->
                  <div class="input-group mb-3">
                      <div class="input-group-prepend">
                          <span class="input-group-text">Owner Name</span>
                      </div>
                      <select id="zone_owner" class="custom-select">
                          <option>Osama</option>
                          <option>Reshma</option>
                      </select>
                  </div>
                  <!-- contact detail input-->
                  <h1 class="display-4">Contact Details</h1>
                  <!-- mobile number -->
                  <div class="input-group mb-3">
                      <div class="input-group-prepend">
                          <span class="input-group-text">Mobile Number</span>
                      </div>
                      <div class="input-group-prepend bg-light">
                          <span class="input-group-text text-primary">+91</span>
                      </div>
                      <input type="number" id="mobile_num" class="form-control" placeholder="Enter your Mobile Number" >
                  </div>
                  <!-- alternate mobile number-->
                  <div class="input-group mb-3">
                      <div class="input-group-prepend">
                          <span class="input-group-text">Alternative Mobile No (if any)</span>
                      </div>
                      <input type="number" id="alter_mobile_num" class="form-control" placeholder="Enter your alternate Mobile Number">
                  </div>
                  <!-- email and confirm email appended view-->
                  <div class="input-group">
                      <div class="input-group-prepend">
                          <span class="input-group-text">Email Address</span>
                      </div>
                      <input id="email" type="text" class="form-control" placeholder="Enter email">
                      <input id="confirm_email" type="text" class="form-control" placeholder="Confirm your Email">
                  </div>
                  <br>
                  <button class="btn btn-block btn-outline-primary" onclick="register_handler()">Register Now</button>
              </div>
              <br>
              <br>
              <div id="alert_placeholder"></div>
          </div>
      </div>
      <script src="JS/register_handler.js"></script>
    <%@include file="includes/bootstrapJSP.jsp" %>
  </body>
</html>